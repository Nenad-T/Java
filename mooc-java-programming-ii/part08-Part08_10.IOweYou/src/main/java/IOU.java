
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sakine
 */
public class IOU {

    private HashMap<String, Double> database;

    public IOU() {
        this.database = new HashMap<>();
    }

    public void setSum(String toWhom, double amount) {
        this.database.put(toWhom, amount);
    }

    public double howMuchDoIOweTo(String toWhom) {
        if (database.containsKey(toWhom)) {
            return database.get(toWhom);
        }
        return 0;
    }

}
