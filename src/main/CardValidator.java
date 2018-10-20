package main;
/* elements.Card validator - checks for valid cards
 Author: Vaidas Vaitkevicius
 Date: 11/10/2018
 */

import elements.Card;

import java.util.ArrayList;

public class CardValidator {

    private ArrayList<String> indexes;
    private ArrayList<String> suits;

    public CardValidator() {
        // list initialisation
        indexes = new ArrayList<>();
        suits = new ArrayList<>();
        // valid card indexes
        this.indexes.add("2");
        this.indexes.add("3");
        this.indexes.add("4");
        this.indexes.add("5");
        this.indexes.add("6");
        this.indexes.add("7");
        this.indexes.add("8");
        this.indexes.add("9");
        this.indexes.add("T");
        this.indexes.add("J");
        this.indexes.add("Q");
        this.indexes.add("K");
        this.indexes.add("A");

        // valid card suits
        this.suits.add("d");
        this.suits.add("c");
        this.suits.add("h");
        this.suits.add("s");
    }

    public int isCardValid(Card card) {
        if ( this.indexes.contains( card.getId() ) ) {
            if ( this.suits.contains( card.getSuit() ) ) {
                // card is valid
                return 1;
            }
        }

        // didn't pass the above checks, therefore card is invalid
        return 0;
    }

}
