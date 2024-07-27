package com.mbtcoding.couchbasedemo.repository;

import com.mbtcoding.couchbasedemo.model.entity.Book;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CouchbaseRepository<Book, String> {
}
