package com.mbtcoding.couchbasedemo.model.api.response.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseErrorResponse{

    private String message;

    private int errorCode;

}
