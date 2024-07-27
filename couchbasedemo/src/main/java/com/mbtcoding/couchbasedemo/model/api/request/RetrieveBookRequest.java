package com.mbtcoding.couchbasedemo.model.api.request;

import com.mbtcoding.couchbasedemo.model.api.response.BaseBookResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RetrieveBookRequest extends BaseBookRequest {
    private String id;
}
