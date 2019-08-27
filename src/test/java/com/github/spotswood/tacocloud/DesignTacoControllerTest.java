package com.github.spotswood.tacocloud;

import com.github.spotswood.tacocloud.controllers.DesignTacoController;
import com.github.spotswood.tacocloud.models.Ingredient;
import com.github.spotswood.tacocloud.models.Taco;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(DesignTacoController.class)
public class DesignTacoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private List<Ingredient> ingredients;
    private Taco design;

    @Before
    public void setup() {
        Ingredient fltoIngredient = new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP);
        Ingredient grbfIngredient =  new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN);
        Ingredient chedIngredient = new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE);
        ingredients = Arrays.asList(
                fltoIngredient,
                new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
                grbfIngredient,
                new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
                chedIngredient,
                new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
        );

        design = new Taco();
        design.setName("Test Taco");
        design.setIngredients(Arrays.asList(fltoIngredient, grbfIngredient, chedIngredient));
    }

    @Test
    public void testShowDesignForm() throws Exception {
        mockMvc.perform(get("/design"))
                .andExpect(status().isOk())
                .andExpect(view().name("design"))
                .andExpect(model().attribute("wrap", ingredients.subList(0, 2)))
                .andExpect(model().attribute("protein", ingredients.subList(2, 4)))
                .andExpect(model().attribute("veggies", ingredients.subList(4, 6)))
                .andExpect(model().attribute("cheese", ingredients.subList(6, 8)))
                .andExpect(model().attribute("sauce", ingredients.subList(8, 10)));
    }

    @Test
    public void processDesign() throws Exception {
        mockMvc.perform(post("/design")
                .content("name=Test+Taco&ingredients=FLTO,GRBF,CHED")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().stringValues("Location", "/orders/current"));
    }
}