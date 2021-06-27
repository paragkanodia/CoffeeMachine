/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import model.beverage.Beverage;
import model.ingridient.Ingridient;
import model.inventory.IngridientInventory;

/**
 *
 * @author paragkanodia
 */
public class CoffeeMachine {
    private IngridientInventory inventory;

    public CoffeeMachine() {
        this.inventory=new IngridientInventory();
    }
    
    public void fillInvetory(Ingridient i, Integer amount)
    {
        inventory.addIngridient(i, amount);
    }
    
    public void processBeverage(Beverage b)
    {
        try
        {
            if(inventory.isInventorySufficient(b))
            {
                System.out.println(b.getName()+" prepared");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void resetInventory()
    {
        inventory.resetInventory();
    }
    
    public void refillIngridient(Ingridient i, Integer amount)
    {
        inventory.addIngridient(i, amount);
    }
    
    public void setMinLevel(Ingridient i, Integer amount)
    {
        inventory.setMinLevel(i, amount);
    }
}
