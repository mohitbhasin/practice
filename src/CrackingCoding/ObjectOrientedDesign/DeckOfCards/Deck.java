import java.util.Random;
import java.util.Stack;

public class Deck {
    Stack<Card> cardDeck;

    Deck() {
        cardDeck = new Stack<>();
        Card card;
        for(Suit s: Suit.values()) {
            for(int i=1; i<=13; i++) {
                boolean face=false;
                if(i==1 || i>10) {
                    face=true;
                }
                card = new Card(s, i, face);
                cardDeck.add(card);
            }
        }
    }

    public void shuffle() {
        Random r = new Random();
        Card temp;
        int val;
        for(int i=cardDeck.size()-1; i>0; i--) {
            val = r.nextInt(i);
            temp = cardDeck.get(i);
            cardDeck.set(i, cardDeck.get(val));
            cardDeck.set(val, temp);
        }
    }

    public static void main(String args[]) {
        Deck deck = new Deck();
        System.out.println(deck.cardDeck);
        deck.shuffle();
        System.out.println("--------");
        System.out.println(deck.cardDeck);
    }
}