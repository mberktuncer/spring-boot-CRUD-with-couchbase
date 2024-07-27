package com.mbtcoding.couchbasedemo.service.impl;


import com.mbtcoding.couchbasedemo.exception.BookNotFoundException;
import com.mbtcoding.couchbasedemo.model.api.request.CreateBookRequest;
import com.mbtcoding.couchbasedemo.model.api.request.DeleteBookRequest;
import com.mbtcoding.couchbasedemo.model.api.request.UpdateBookRequest;
import com.mbtcoding.couchbasedemo.model.api.response.CreateBookResponse;
import com.mbtcoding.couchbasedemo.model.api.response.DeleteBookResponse;
import com.mbtcoding.couchbasedemo.model.api.response.RetrieveBookResponse;
import com.mbtcoding.couchbasedemo.model.api.response.UpdateBookResponse;
import com.mbtcoding.couchbasedemo.model.entity.Book;
import com.mbtcoding.couchbasedemo.repository.BookRepository;
import com.mbtcoding.couchbasedemo.service.concract.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.MapperUtil;


@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    private final BookRepository bookRepository;

    public List<RetrieveBookResponse> findAll() {

        var allEntity = bookRepository.findAll();

        List<RetrieveBookResponse> response = new ArrayList<>();

        logger.info("Starting to process findAll method");

        for(var entity : allEntity){
            RetrieveBookResponse retrieveBookResponse = MapperUtil.map(entity, RetrieveBookResponse.class);

            response.add(retrieveBookResponse);

            logger.info("Processed book: {}", retrieveBookResponse);
        }

        logger.info("Completed processing findAll method");
        return response;
    }

    public RetrieveBookResponse findById(String id) {

        var entity = bookRepository.findById(id);
        Book bookEntity = null;

        if(entity.isPresent()){
            bookEntity = entity.get();
        }
        else{
            throw new BookNotFoundException("Book not found with id: " + id);
        }

        RetrieveBookResponse retrieveBookResponse = MapperUtil.map(bookEntity, RetrieveBookResponse.class);

        logger.info("Returning book for id {}: {}", id, retrieveBookResponse);

        return  retrieveBookResponse;
    }

    public CreateBookResponse save(CreateBookRequest createBookRequest) {

        Book theBook = new Book();
        theBook.setTitle(createBookRequest.getTitle());
        theBook.setAuthor(createBookRequest.getAuthor());

        Book savedBook = bookRepository.save(theBook);

        CreateBookResponse createBookResponse = MapperUtil.map(savedBook, CreateBookResponse.class);

        logger.info("Saved book: {}", createBookResponse);

        return createBookResponse;
    }

    @Override
    public UpdateBookResponse update(UpdateBookRequest updateBookRequest) {

        var bookEntity = bookRepository.findById(updateBookRequest.getId());

        if (bookEntity.isPresent()){

            var bookData = bookEntity.get();
            bookData.setAuthor(updateBookRequest.getAuthor());
            bookData.setTitle(updateBookRequest.getTitle());
            bookRepository.save(bookData);

            UpdateBookResponse updateBookResponse = MapperUtil.map(bookData, UpdateBookResponse.class);

            return updateBookResponse;
        }
        else{
            throw new BookNotFoundException("Book not found with id: " + updateBookRequest.getId());
        }
    }

    public DeleteBookResponse deleteById(DeleteBookRequest deleteBookRequest) {

        var bookEntity = bookRepository.findById(deleteBookRequest.getId());
        if (bookEntity.isPresent()) {

            var bookData = bookEntity.get();

            bookRepository.deleteById(bookData.getId());

            DeleteBookResponse deleteBookResponse = MapperUtil.map(bookData, DeleteBookResponse.class);

            logger.info("Deleted book: {}", deleteBookResponse);

            return deleteBookResponse;

        } else {
            throw new BookNotFoundException("Book not found for id :: " + deleteBookRequest.getId());
        }
    }
}
