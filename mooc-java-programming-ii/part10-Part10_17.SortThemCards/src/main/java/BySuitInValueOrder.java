
import java.util.Comparator;

public class BySuitInValueOrder implements Comparator<Card> {

    public BySuitInValueOrder() {
    }

    @Override
    public int compare(Card c1, Card c2) {
        return (c1.getValue() + c1.getSuit().ordinal()) - (c2.getValue() + c2.getSuit().ordinal());
    }
}
