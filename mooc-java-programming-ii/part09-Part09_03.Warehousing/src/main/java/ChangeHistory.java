
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sakine
 */
public class ChangeHistory {

    private ArrayList<Double> changeHistory;

    public ChangeHistory() {
        this.changeHistory = new ArrayList<Double>();
    }

    public void add(double status) {
        this.changeHistory.add(status);
    }

    public void clear() {
        this.changeHistory.clear();
    }

    @Override
    public String toString() {
        return this.changeHistory.toString();
    }

    public double maxValue() {
        double max = 0.0;
        for (double value : this.changeHistory) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public double minValue() {
        if (this.changeHistory.isEmpty()) {
            return 0;
        }
        double min = this.changeHistory.get(0);
        for (double value : this.changeHistory) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
    
    public double average(){
        double sum = 0.0;
        for (double value : this.changeHistory){
            sum += value;
        }
        return sum/this.changeHistory.size();
    }
}
