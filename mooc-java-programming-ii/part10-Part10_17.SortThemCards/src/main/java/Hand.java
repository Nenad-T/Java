
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Hand implements Comparable<Hand> {

    private List<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }

    public void add(Card card) {
        this.hand.add(card);
    }

    public void print() {
        Iterator<Card> iterator = hand.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public List<Card> getHand() {
        return this.hand;
    }

    public void sort() {
        Collections.sort(hand);
    }

    @Override
    public int compareTo(Hand o) {
        int a = 0;
        int b = 0;
        for (Card c : this.hand) {
            a += c.getValue();
           // a += c.getSuit().ordinal();
        }
        for (Card c : o.getHand()) {
            b += c.getValue();
           // b += c.getSuit().ordinal();
        }
        return a - b;
    }

    public void sortBySuit() {
        SortBySuit sortBySuitSorter = new SortBySuit();
        BySuitInValueOrder sorterByValue = new BySuitInValueOrder();

        Collections.sort(this.hand, sorterByValue);
        Collections.sort(this.hand, sortBySuitSorter);
    }

}
