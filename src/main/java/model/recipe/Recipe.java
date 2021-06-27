/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.recipe;

import model.beverage.Beverage;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import model.ingridient.Ingridient;

/**
 *
 * @author paragkanodia
 * 
 * This class encapsulates Ingridients required to make a beverage.
 * A beverage can have raw ingridients or a beverage itself
 */
public class Recipe {
    private Map<Ingridient,Integer> ingridients;
    private List<Beverage> beverages;

    public Recipe(Map<Ingridient, Integer> ingridients, List<Beverage> beverages) {
        this.ingridients = ingridients;
        this.beverages = beverages;
    }
    
    public Map<Ingridient,Integer> getAllIngridients()
    {
        Map<Ingridient,Integer> allIngridents=new LinkedHashMap<>();
        allIngridents.putAll(ingridients);
        for(Beverage b: beverages)
        {
            Map<Ingridient,Integer> tempIngridients= b.getIngridients();
            for(Ingridient i: tempIngridients.keySet())
            {
                if(allIngridents.containsKey(i))
                    allIngridents.put(i, allIngridents.get(i)+tempIngridients.get(i));
                else
                    allIngridents.put(i, tempIngridients.get(i));
            }
        }
        return allIngridents;
    }
}
