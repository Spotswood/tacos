package com.github.spotswood.tacocloud.repositories;

import com.github.spotswood.tacocloud.models.Ingredient;

import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
