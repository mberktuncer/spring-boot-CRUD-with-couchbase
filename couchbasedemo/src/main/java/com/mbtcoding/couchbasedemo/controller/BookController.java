package com.mbtcoding.couchbasedemo.controller;

import com.mbtcoding.couchbasedemo.model.api.request.CreateBookRequest;
import com.mbtcoding.couchbasedemo.model.api.request.DeleteBookRequest;
import com.mbtcoding.couchbasedemo.model.api.request.UpdateBookRequest;
import com.mbtcoding.couchbasedemo.model.api.response.CreateBookResponse;
import com.mbtcoding.couchbasedemo.model.api.response.DeleteBookResponse;
import com.mbtcoding.couchbasedemo.model.api.response.RetrieveBookResponse;
import com.mbtcoding.couchbasedemo.model.api.response.UpdateBookResponse;
import com.mbtcoding.couchbasedemo.service.concract.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<RetrieveBookResponse> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public RetrieveBookResponse getBook(@PathVariable String id) {
        return bookService.findById(id);
    }

    @PostMapping
    public CreateBookResponse addBook(@RequestBody CreateBookRequest createBookRequest) {
        return bookService.save(createBookRequest);
    }

    @PutMapping
    public UpdateBookResponse updateBook(@RequestBody UpdateBookRequest updateBookRequest) {
        return bookService.update(updateBookRequest);
    }

    @DeleteMapping
    public DeleteBookResponse deleteBook(@RequestBody DeleteBookRequest deleteBookRequest) {
        return bookService.deleteById(deleteBookRequest);
    }
}
