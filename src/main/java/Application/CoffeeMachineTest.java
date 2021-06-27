/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import model.beverage.HotTea;
import model.beverage.HotCoffee;
import model.beverage.GreenTea;
import model.beverage.BlackTea;
import model.beverage.Beverage;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import model.ingridient.Ingridient;
import model.recipe.Recipe;

/**
 *
 * @author paragkanodia
 */
public class CoffeeMachineTest {
    public static void main(String[] args)
    {
        CoffeeMachine machine=new CoffeeMachine();
        Ingridient hotWater=new Ingridient("hot water");
        Ingridient hotMilk=new Ingridient("hot milk");
        Ingridient gingerSyrup=new Ingridient("ginger Syrup");
        Ingridient sugarSyrup=new Ingridient("sugar Syrup");
        Ingridient teaLeavesSyrup=new Ingridient("tea Leaves Syrup");
        Ingridient greenMixture=new Ingridient("green Mixture");
        
        machine.fillInvetory(hotWater, 500);
        machine.fillInvetory(hotMilk, 500);
        machine.fillInvetory(gingerSyrup, 100);
        machine.fillInvetory(sugarSyrup, 100);
        machine.fillInvetory(teaLeavesSyrup, 100);
        
        Map<Ingridient,Integer> m=new LinkedHashMap<>();
        m.put(hotWater, 200);
        m.put(hotMilk, 100);
        m.put(gingerSyrup, 10);
        m.put(sugarSyrup, 10);
        m.put(teaLeavesSyrup, 30);
        Recipe hotTeaRecipe= new Recipe(m,new ArrayList<>());
        Beverage hotTea= new HotTea("Hot Tea",hotTeaRecipe);
        
        Map<Ingridient,Integer> m1=new LinkedHashMap<>();
        m1.put(hotWater, 100);
        m1.put(hotMilk, 400);
        m1.put(gingerSyrup, 30);
        m1.put(sugarSyrup, 50);
        m1.put(teaLeavesSyrup, 30);
        Recipe hotCoffeeRecipe= new Recipe(m1,new ArrayList<>());
        Beverage hotCoffee= new HotCoffee("Hot Coffee",hotCoffeeRecipe);
        
        Map<Ingridient,Integer> m2=new LinkedHashMap<>();
        m2.put(hotWater, 300);
        m2.put(gingerSyrup, 30);
        m2.put(sugarSyrup, 50);
        m2.put(teaLeavesSyrup, 30);
        Recipe blackTeaecipe= new Recipe(m2,new ArrayList<>());
        Beverage blackTea= new BlackTea("Black Tea",blackTeaecipe);
        
        Map<Ingridient,Integer> m3=new LinkedHashMap<>();
        m3.put(hotWater, 100);
        m3.put(gingerSyrup, 30);
        m3.put(sugarSyrup, 50);
        m3.put(greenMixture, 30);
        Recipe greenTeaRecipe= new Recipe(m3,new ArrayList<>());
        Beverage greenTea = new GreenTea("Green Tea",greenTeaRecipe);
         
       //TEST -1
       machine.processBeverage(hotTea);
       machine.processBeverage(hotCoffee);
       machine.processBeverage(greenTea);
       machine.processBeverage(blackTea);
       
       //TEST -2
        System.out.println("--------------------------------------------");
        machine.resetInventory();
        machine.fillInvetory(hotWater, 500);
        machine.fillInvetory(hotMilk, 500);
        machine.fillInvetory(gingerSyrup, 100);
        machine.fillInvetory(sugarSyrup, 100);
        machine.fillInvetory(teaLeavesSyrup, 100);
        
        machine.processBeverage(hotTea);
        machine.processBeverage(blackTea);
        machine.processBeverage(greenTea);
        machine.processBeverage(hotCoffee);
        
        //TEST -3
        System.out.println("--------------------------------------------");
        machine.resetInventory();
        machine.fillInvetory(hotWater, 500);
        machine.fillInvetory(hotMilk, 500);
        machine.fillInvetory(gingerSyrup, 100);
        machine.fillInvetory(sugarSyrup, 100);
        machine.fillInvetory(teaLeavesSyrup, 100);
        
        machine.processBeverage(hotCoffee);
        machine.processBeverage(blackTea);
        machine.processBeverage(greenTea);
        machine.processBeverage(hotTea);

    }
        
}
