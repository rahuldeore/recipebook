package com.rahul.recipebook;

import com.rahul.recipebook.domain.Recipe;
import com.rahul.recipebook.service.RecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RecipebookApplicationTests {

	@Autowired
	RecipeService recipeService;

	@Test
	void contextLoads() {
	}

	@Test
	void findRecipe_Valid_Test() {
		String id = "5f9767b15ef2003ada33b180";
		Recipe recipe = recipeService.findRecipe(id);
		System.out.println(recipe.getRecipeName());
	}

	@Test
	void findAllRecipe_Test() {
		List<Recipe> recipes = recipeService.findAllRecipes();
		recipes.forEach(recipe -> {
			System.out.print(recipe.getRecipeName() + "\t");
			System.out.println(recipe.getId());
		});
	}

}
