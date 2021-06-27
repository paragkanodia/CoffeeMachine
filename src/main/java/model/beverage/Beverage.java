package model.beverage;


import java.util.Map;
import model.ingridient.Ingridient;
import model.recipe.Recipe;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paragkanodia
 * 
 *
 */
public class Beverage {
    private final String name;
    private Recipe recipe;
    
    public Beverage(String name, Recipe recipe) {
        this.name = name;
        this.recipe = recipe;
    }

    public Recipe getReceipe() {
        return recipe;
    }
    
    public String getName() {
        return name;
    }

    public Map<Ingridient, Integer> getIngridients() {
        return recipe.getAllIngridients();
    }
    
    public void makeProcess()
    {
        
    }
}
