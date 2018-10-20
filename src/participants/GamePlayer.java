package participants;
/* Parent class for participants.Dealer and participants.Player classes
 Author: Vaidas Vaitkevicius
 Date: 18/10/2018
 */

import elements.Action;
import elements.Card;
import elements.Hand;

import java.util.ArrayList;

public class GamePlayer {

    private Hand hand;
    private String state;
    private Integer score;
    private Action action;

    public static String STATE_INACTIVE = "inactive";
    public static String STATE_GAME = "in_game";
    public static String STATE_GAME_BUST = "bust";

    GamePlayer() {
        this.hand = new Hand();
        this.state = "inactive";
        this.action = new Action();
    }

    /**
     * Adds a card to the cards held
     * @param c elements.Card to add
     */
    public void giveCard(Card c) {
        this.hand.add(c);
    }

    /**
     * Removes all cards from the player's hand
     */
    public void clearHand() {
        this.hand.clear();
    }

    /**
     * Retrieves all cards held
     *
     * @return List of cards
     */
    public ArrayList<Card> getHand() {
        return this.hand.getCards();
    }

    /**
     * Sets participant's state
     * @param state State (string) to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Retrieves participant's state
     * @return State (string)
     */
    public String getState() {
        return this.state;
    }

    /**
     * Sets player's hand score
     * @param score Score to set (Integer)
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * Retrieves player's hand score
     * @return Player's hand score
     */
    public Integer getScore() {
        return this.score;
    }

    public Action getAction() {
        return this.action;
    }
}
