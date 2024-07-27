package com.mbtcoding.couchbasedemo.model.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class BaseBookRequest {
    private String title;
    private String author;
}
