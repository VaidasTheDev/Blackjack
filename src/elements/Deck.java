package elements;
/* elements.Card deck definition
 Author: Vaidas Vaitkevicius
 Date: 18/10/2018
 */

import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards;

    public Deck () {
        this.cards = new ArrayList<>();

        // Populating the card set with conventional 52 card deck
        // Diamonds
        for (int i = 2; i < 10; i++) {
            this.cards.add(new Card(i + "d"));
        }
        this.cards.add(new Card("Td"));
        this.cards.add(new Card("Jd"));
        this.cards.add(new Card("Qd"));
        this.cards.add(new Card("Kd"));
        this.cards.add(new Card("Ad"));
        // Clubs
        for (int i = 2; i < 10; i++) {
            this.cards.add(new Card(i + "c"));
        }
        this.cards.add(new Card("Tc"));
        this.cards.add(new Card("Jc"));
        this.cards.add(new Card("Qc"));
        this.cards.add(new Card("Kc"));
        this.cards.add(new Card("Ac"));
        // Hearts
        for (int i = 2; i < 10; i++) {
            this.cards.add(new Card(i + "h"));
        }
        this.cards.add(new Card("Th"));
        this.cards.add(new Card("Jh"));
        this.cards.add(new Card("Qh"));
        this.cards.add(new Card("Kh"));
        this.cards.add(new Card("Ah"));
        // Spades
        for (int i = 2; i < 10; i++) {
            this.cards.add(new Card(i + "s"));
        }
        this.cards.add(new Card("Ts"));
        this.cards.add(new Card("Js"));
        this.cards.add(new Card("Qs"));
        this.cards.add(new Card("Ks"));
        this.cards.add(new Card("As"));
    }

    /**
     * Provides a deck of 52 cards
     *
     * @return 52 cards (deck)
     */
    public ArrayList<Card> getCards() {
        return this.cards;
    }
}
