package com.rahul.recipebook.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Map;

/**
 * Created by Rahul on 10/19/20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Recipe {

    String id;
    String recipeName;
    String description;
    String prepTime;
    String cookTime;
    String servers;
    Map<String, String> ingredients;
    // add directions later
}
