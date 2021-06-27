package model.inventory;

import model.beverage.Beverage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paragkanodia
 */
public interface Inventory {
        public boolean isInventorySufficient(Beverage beverage);

}
