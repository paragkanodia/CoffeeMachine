/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.recipe;

import model.beverage.Beverage;
import java.util.List;
import java.util.Map;
import model.ingridient.Ingridient;

/**
 *
 * @author paragkanodia
 */
public class HotCoffeeRecipe extends Recipe{

    public HotCoffeeRecipe(Map<Ingridient, Integer> ingridients, List<Beverage> beverages) {
        super(ingridients, beverages);
    }
    
}
