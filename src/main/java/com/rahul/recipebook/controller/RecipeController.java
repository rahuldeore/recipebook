package com.rahul.recipebook.controller;

import com.rahul.recipebook.domain.GenericResponse;
import com.rahul.recipebook.domain.Recipe;
import com.rahul.recipebook.repository.RecipeBookRepository;
import com.rahul.recipebook.service.RecipeService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by Rahul on 10/19/20
 */
@RestController
@RequestMapping(path = "/recipeapp/v1/recipes")
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<Recipe> getAllRecipes(@RequestParam(name = "recipeName", required = false) String recipeName) {
        return recipeService.findAllRecipes();
    }

    @GetMapping("/{id}")
    public GenericResponse getRecipeById(@PathVariable(name="id", required = true) String id) {

        Recipe recipe = recipeService.findRecipe(id);
        if (recipe != null) {
            return GenericResponse.builder()
                    .object(recipe)
                    .message("Success")
                    .build();
        } else {
            return GenericResponse.builder()
                    .object(null)
                    .message("Fail")
                    .build();
        }
    }

    @PostMapping
    GenericResponse insertRecipe(@RequestBody Recipe recipe) {

        Recipe resp = recipeService.saveRecipe(recipe);
        if (resp != null) {
            return GenericResponse.builder()
                    .message("Insert Successful: " + resp.getId())
                    .object(recipe)
                    .build();
        } else {
            return GenericResponse.builder()
                    .message("Insert Failed")
                    .build();
        }
    }
}
