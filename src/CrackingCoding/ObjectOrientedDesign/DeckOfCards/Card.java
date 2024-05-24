public class Card {
    Suit suit;
    int number;
    boolean face;

    Card(Suit s, int n, boolean f) {
        suit = s;
        number = n;
        face = f;
    }

    public String toString() {
        return String.valueOf(number) + suit;
    }
}
