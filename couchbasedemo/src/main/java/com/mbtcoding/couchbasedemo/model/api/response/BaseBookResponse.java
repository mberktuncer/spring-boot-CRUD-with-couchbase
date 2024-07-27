package com.mbtcoding.couchbasedemo.model.api.response;

import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseBookResponse {
    private String id;
    private String title;
    private String author;
}
