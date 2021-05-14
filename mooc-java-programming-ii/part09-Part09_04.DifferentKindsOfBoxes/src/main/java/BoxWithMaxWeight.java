
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
public class BoxWithMaxWeight extends Box {

    private int capacity;
    private ArrayList<Item> items;

    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();

    }

    @Override
    public void add(Item item) {
        if (capacity - item.getWeight() >= 0) {
            items.add(item);
            capacity = capacity - item.getWeight();
        }
    }

    @Override
    public boolean isInBox(Item item) {
        boolean isInBox = false;
        for (Item it : items) {
            if (it.equals(item)) {
                isInBox = true;
            }
        }
        return isInBox;

    }
}
