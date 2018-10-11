
/* Card object
 Author: Vaidas Vaitkevicius
 Date: 11/10/2018
 */

public class Card {

    private String identifier;
    private String suit;


    /**
     * Card constructor
     *
     * @param name name of a card (e.g. 2h which evaluates to: two of hearts)
     */
    public Card (String name) {
        String[] parts = name.split("");
        this.identifier = parts[0s];
        this.suit = parts[1];
    }

    public String getId() {
        return this.identifier;
    }

    public String getSuit() {
        return this.suit;
    }

}
