
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
public class Herd implements Movable {

    private ArrayList<Movable> herd;
    
    public Herd() {
        this.herd = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        String movables = new String();
        movables = this.herd.stream().map((mo) -> "\n" + mo.toString()).reduce(movables, String::concat);
        return movables;
    }

    public void addToHerd(Movable movable) {
        this.herd.add(movable);
    }
    
    @Override
    public void move(int dx, int dy) {
        this.herd.forEach((mo) -> {
            mo.move(dx, dy);
        });
    }
    
}
