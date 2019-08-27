package com.github.spotswood.tacocloud.repositories;

import com.github.spotswood.tacocloud.models.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Ingredient findById(String id);

    Ingredient save(Ingredient ingredient);

}
