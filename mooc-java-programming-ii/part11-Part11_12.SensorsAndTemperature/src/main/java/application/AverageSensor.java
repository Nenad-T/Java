/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sakine
 */
public class AverageSensor implements Sensor {

    private List<Integer> readings = new ArrayList<>();

    private final ArrayList<Sensor> sensors = new ArrayList<>();

    public AverageSensor() {
    }

    @Override
    public boolean isOn() {
        boolean on = true;
        for (Sensor sensor : this.sensors) {
            if (!sensor.isOn()) {
                on = false;
            }
        }
        return on;
    }

    @Override
    public void setOn() {
        this.sensors.forEach((sensor) -> {
            sensor.setOn();
        });
    }

    @Override
    public void setOff() {
        this.sensors.forEach((sensor) -> {
            sensor.setOff();
        });
    }

    @Override
    public int read() {
        int average;
        int sum = 0;
        if (this.sensors.isEmpty() || isOn() == false) {
            throw new IllegalStateException();
        }
        sum = this.sensors.stream().map((sensor) -> sensor.read()).reduce(sum, Integer::sum);
        average = sum / this.sensors.size();
        this.readings.add(average);
        return average;

    }

    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }

    public List<Integer> readings() {
        return readings;
    }

}
