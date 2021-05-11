/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sakine
 */
public class Container {

    int containerAmount = 0;
    int max = 100;

    public Container() {
    }

    public int contains() {
        return containerAmount;
    }

    public void add(int amount) {
        if (amount < 0) {
            return;
        } else {
            if (containerAmount + amount > max) {
                containerAmount = max;
            } else {
                containerAmount += amount;
            }
        }
    }
    public void remove(int amount){
            if (amount < 0) {
            return;
        } else {
            if (containerAmount - amount < 0) {
                containerAmount = 0;
            } else {
                containerAmount -= amount;
            }
        }
    }

    @Override
    public String toString() {
        return containerAmount + "/" + max;
    }
    
}
