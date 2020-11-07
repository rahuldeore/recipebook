package com.rahul.recipebook.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Created by Rahul on 10/26/20
 */
@Data
@Builder
@AllArgsConstructor
public class GenericResponse<T> {

    String message;
    T object;

}
