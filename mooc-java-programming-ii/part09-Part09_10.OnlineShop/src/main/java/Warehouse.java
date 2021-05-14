
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sakine
 */
public class Warehouse {

    private Map<String, Integer> price;
    private Map<String, Integer> stock;

    public Warehouse() {
        this.price = new HashMap<>();
        this.stock = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        this.price.put(product, price);
        this.stock.put(product, stock);
    }

    public int price(String product) {
        if (price.containsKey(product)) {
            return price.get(product);
        }
        return -99;
    }

    public int stock(String product) {
        if (stock.containsKey(product)) {
            return stock.get(product);
        }
        return 0;
    }

    public boolean take(String product) {
        if (stock.containsKey(product)) {
            if (stock.get(product) > 0) {
                int st = stock.get(product);
                st -= 1;
                stock.put(product, st);
                return true;
            }
        }
        return false;
    }

    public Set<String> products() {
        Set<String> keys = stock.keySet();
        return keys;
    }
}
