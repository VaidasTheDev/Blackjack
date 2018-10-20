package participants;
/* elements.Card dealer (server) - deals cards
 Author: Vaidas Vaitkevicius
 Date: 14/10/2018
 */

import elements.Card;
import java.util.ArrayList;
import java.util.Random;

public class Dealer extends GamePlayer {

    /**
     * Empty constructor
     */
    public Dealer() {
        super();
    }

    /**
     * Shuffles a stack of cards
     *
     * @return shuffled cards
     */
    public ArrayList<Card> shuffleDeck(ArrayList<Card> deck) {
        Random random = new Random();
        ArrayList<Card> new_deck = new ArrayList<>(deck);

        // Shuffle the new deck
        for (int i = 0; i < new_deck.size(); i++) {
            // random position of the remaining cards
            int r = i + random.nextInt(new_deck.size() - i);

            // Swap card positions
            Card rCard = new_deck.get(r);
            Card card = new_deck.get(i);
            new_deck.set(r, card);
            new_deck.set(i, rCard);
        }

        return new_deck;
    }
}
