package com.mbtcoding.couchbasedemo.service.concract;

import com.mbtcoding.couchbasedemo.model.api.request.CreateBookRequest;
import com.mbtcoding.couchbasedemo.model.api.request.DeleteBookRequest;
import com.mbtcoding.couchbasedemo.model.api.request.RetrieveBookRequest;
import com.mbtcoding.couchbasedemo.model.api.request.UpdateBookRequest;
import com.mbtcoding.couchbasedemo.model.api.response.CreateBookResponse;
import com.mbtcoding.couchbasedemo.model.api.response.DeleteBookResponse;
import com.mbtcoding.couchbasedemo.model.api.response.RetrieveBookResponse;
import com.mbtcoding.couchbasedemo.model.api.response.UpdateBookResponse;
import com.mbtcoding.couchbasedemo.model.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<RetrieveBookResponse> findAll();
    RetrieveBookResponse findById(String id);
    public CreateBookResponse save(CreateBookRequest createBookRequest);
    public UpdateBookResponse update(UpdateBookRequest updateBookRequest);
    public DeleteBookResponse deleteById(DeleteBookRequest deleteBookRequest);


}
