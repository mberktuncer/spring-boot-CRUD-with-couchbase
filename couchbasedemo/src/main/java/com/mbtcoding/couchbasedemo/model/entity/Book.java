package com.mbtcoding.couchbasedemo.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import static com.mbtcoding.couchbasedemo.constants.database.DatabaseConstants.BOOK_COLLECTION;


@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
@TypeAlias(BOOK_COLLECTION)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private String id;
    private String title;
    private String author;
}
