
/* Hand object
 Author: Vaidas Vaitkevicius
 Date: 11/10/2018
 */

import java.util.ArrayList;

public class Hand {

    private ArrayList<String> cards = new ArrayList<>();

    public Hand() {
        // constructor to-be-filled
    }

    /**
     * Card adder
     *
     * @param card Card to add to the hand
     */
    public void addCard (String card) {
        this.cards.add(card);
    }

    /**
     * Hand getter
     *
     * @return all cards that belong to the hand
     */
    public ArrayList<String> getCards() {
        return this.cards;
    }
}
