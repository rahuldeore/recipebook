package com.rahul.recipebook.repository;

import com.rahul.recipebook.domain.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.ObjectInput;
import java.util.List;
import java.util.Optional;

/**
 * Created by Rahul on 10/26/20
 */
public interface RecipeBookRepository extends MongoRepository<Recipe, String> {

}
