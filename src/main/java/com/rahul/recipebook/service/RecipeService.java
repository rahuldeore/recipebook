package com.rahul.recipebook.service;

import com.rahul.recipebook.domain.Recipe;

import java.util.List;

/**
 * Created by Rahul on 11/6/20
 */
public interface RecipeService {
    Recipe saveRecipe(Recipe recipe);
    Recipe findRecipe(String id);
    List<Recipe> findAllRecipes();
}
