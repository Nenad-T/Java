/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author Sakine
 */
public class TemperatureSensor implements Sensor {

    private boolean on = false;

    public TemperatureSensor() {
    }
    
    

    @Override
    public boolean isOn() {
        return this.on;
    }

    @Override
    public void setOn() {
        this.on = true;
    }

    @Override
    public void setOff() {
        this.on = false;
    }

    @Override
    public int read() {
        if (on == false) {
            throw new IllegalStateException();
        }
        int randNumber = new Random().nextInt(61) - 30;
        return randNumber;
    }

}
