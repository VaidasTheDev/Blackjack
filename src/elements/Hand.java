package elements;
/* elements.Hand object
 Author: Vaidas Vaitkevicius
 Date: 11/10/2018
 */

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cards = new ArrayList<>();

    public Hand() {
        // constructor to-be-filled
    }

    /**
     * Card adder
     *
     * @param card elements.Card to add to the hand
     */
    public void add (Card card) {
        this.cards.add(card);
    }

    /**
     * Cards getter
     *
     * @return all cards that belong to the hand
     */
    public ArrayList<Card> getCards() {
        return this.cards;
    }

    /**
     * Clears all cards from the hand
     */
    public void clear() {
        this.cards.clear();
    }
}
