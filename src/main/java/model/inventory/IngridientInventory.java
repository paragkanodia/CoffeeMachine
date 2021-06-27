package model.inventory;


import model.beverage.Beverage;
import exceptions.IngridientNotAvailable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import model.ingridient.Ingridient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paragkanodia
 */
public class IngridientInventory implements Inventory{
    private Map<Ingridient,Integer> inventory;
    private Map<Ingridient,Integer> minLevel;

    public IngridientInventory() {
        this.inventory = new LinkedHashMap<>();
        this.minLevel=new HashMap<>();
    }
    
    @Override
    public synchronized boolean isInventorySufficient(Beverage beverage)
    {
        Map<Ingridient, Integer> ingridients = beverage.getIngridients();
        Set<Ingridient> keySet = ingridients.keySet();
        for(Ingridient i:keySet)
        {
            if(!inventory.containsKey(i))
                throw new IngridientNotAvailable(beverage.getName()+" cannot be prepared because "+i.getName()+" is not available");
            
        }
        
        for(Ingridient i:keySet)
        {
                if(inventory.get(i).compareTo(ingridients.get(i))<0)
                    throw new IngridientNotAvailable(beverage.getName()+" cannot be prepared because "+i.getName()+" is not sufficient");
            
        }
        reduceInventory(beverage);
        return true;
    }
    private void reduceInventory(Beverage beverage)
    {
        Map<Ingridient, Integer> ingridients = beverage.getIngridients();
        Set<Ingridient> keySet = ingridients.keySet();
        keySet.forEach(i -> {
            inventory.put(i, inventory.get(i)-ingridients.get(i));
            if(inventory.get(i).compareTo(minLevel.get(i))<=0)
                turnOnIndicator(i);
        });
    }
    
    public void turnOnIndicator(Ingridient i)
    {
        
    }
    public void addIngridient(Ingridient i, Integer amount)
    {
        if(inventory.containsKey(i))
            inventory.put(i, amount+inventory.get(i));
        else
            inventory.put(i, amount);
        
        minLevel.put(i, 0);
    }
    
    public void setMinLevel(Ingridient i, Integer amount)
    {
        minLevel.put(i, amount);
    }
    
    public void resetInventory()
    {
        inventory.clear();
    }
}
