
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
public class Box implements Packable{

    private double maxWeight;
    private ArrayList<Packable> list;

    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
        list = new ArrayList<>();
    }

    public void add(Packable item) {
        if (this.weight() + item.weight() <= this.maxWeight) {
            this.list.add(item);
        }
    }
    
    public double weight(){
        double weight = 0;
        for(Packable pac : list){
            weight += pac.weight();
        }
        return weight;
    
    }
    @Override
    public String toString() {
        return "Box: " + list.size() + " items, total weight " + this.weight() + " kg";
    }

}
