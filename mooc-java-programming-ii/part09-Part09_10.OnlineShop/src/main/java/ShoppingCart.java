
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sakine
 */
public class ShoppingCart {

    private List<Item> cart;

    public ShoppingCart() {
        this.cart = new ArrayList<>();
    }

    public void add(String product, int price) {
        Item item = new Item(product, 1, price);
        boolean isHere= false;
        for (Item it : cart){
            if (it.getProduct().contains(product)){
                it.increaseQuantity();
                isHere = true;
                break;
            }
        }
        if (isHere == false){
            cart.add(item);
        }
    }

    public int price() {
        int amount = 0;
        for (int i = 0; i < cart.size(); i++) {
            amount += cart.get(i).price();
        }
        return amount;
    }

    public void print() {
        for (Item it : cart) {
            System.out.println(it.toString());
        }

    }
}
