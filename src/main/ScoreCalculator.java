package main;
/* elements.Card score calculator
 Author: Vaidas Vaitkevicius
 Date: 15/10/2018
 */

import elements.Card;

import java.util.ArrayList;
import java.util.HashMap;

public class ScoreCalculator {

    // Format: key = 'card index', value = 'card value'
    private static HashMap<String, Integer> values;
    public static Integer blackJack = 50;

    public ScoreCalculator() {
        // initialise hashmap for 'values'
        values = new HashMap<>();
        // initialise card values
        values.put("2", 2);
        values.put("3", 3);
        values.put("4", 4);
        values.put("5", 5);
        values.put("6", 6);
        values.put("7", 7);
        values.put("8", 8);
        values.put("9", 9);
        values.put("T", 10);
        values.put("J", 10);
        values.put("Q", 10);
        values.put("K", 10);
        values.put("A", 11);
    }

    public Integer getCardValue(Card card) {
        return values.get(card.getId());
    }

    public Integer getHandValue(ArrayList<Card> hand) {
        Integer score = 0;
        int num_aces = 0;
        for (Card c : hand) {
            // special case for card 'Ace'
            if (c.getId().equals("A")) {
                num_aces++;
            } else {
                score += values.get(c.getId());
            }
        }

        // add values of 'aces'
        for (int i = 0; i < num_aces; i++) {
            if (score + values.get("A") > 21) {
                score += 1;
            } else {
                score += values.get("A");
            }
        }

        // detect a blackjack (2 cards, total value = 21)
        if (hand.size() == 2 && score == 21) {
            score = blackJack;
        }

        return score;
    }
}
