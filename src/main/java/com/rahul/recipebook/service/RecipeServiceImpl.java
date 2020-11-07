package com.rahul.recipebook.service;

import com.rahul.recipebook.domain.Recipe;
import com.rahul.recipebook.repository.RecipeBookRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Rahul on 11/6/20
 */
@Service
public class RecipeServiceImpl implements RecipeService{

    private RecipeBookRepository recipeRepository;

    public RecipeServiceImpl(RecipeBookRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe findRecipe(String id) {
        Optional<Recipe> resp = recipeRepository.findById(id);
        return resp.isPresent() ? resp.get() : null;
    }

    @Override
    public List<Recipe> findAllRecipes() {
        return recipeRepository.findAll();
    }
}
