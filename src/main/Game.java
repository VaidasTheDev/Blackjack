package main;
/* Game object
 Author: Vaidas Vaitkevicius
 Date: 15/10/2018
 */

import elements.Card;
import elements.Deck;
import participants.Dealer;
import participants.GamePlayer;
import participants.Player;

import java.util.ArrayList;

public class Game {

    private ArrayList<Card> deck;
    private Integer no_decks;
    private ArrayList<Player> players;
    private Dealer dealer;
    private int next_player;
    private ActionValidator actionValidator;
    private ScoreCalculator scoreCalc;

    /**
     * Constructor
     */
    public Game() {
        // Initialises instance's variables
        this.deck = new ArrayList<>();
        this.no_decks = 1;
        this.players = new ArrayList<>();
        this.dealer = new Dealer();
        this.actionValidator = new ActionValidator();
        this.scoreCalc = new ScoreCalculator();
    }

    /**
     * Increases number of card decks this game will use
     * (a game may have a deck which consists of X number of card decks)
     */
    public void setDeckNo(Integer number) {
        this.no_decks = number;
    }

    /**
     * Clears current deck AND
     * adds number of single card decks (52 cards) equivalent to 'no_decks' value
     */
    public void resetDeck() {
        this.deck.clear();
        ArrayList<Card> single_deck = new Deck().getCards();
        for (int i = 0; i < this.no_decks; i++) {
            this.deck.addAll(single_deck);
        }
    }

    /**
     * Adds a player to the game
     *
     * @param p participants.Player
     */
    public void addPlayer(Player p) {
        this.players.add(p);
    }

    /**
     * Sets next player to deal a card to
     * Special case: if there is no more players to follow, reset to first player
     */
    private void nextPlayer() {
        if (this.next_player != (this.players.size() -1) ) {
            this.next_player ++;
        } else {
            this.next_player = 0;
        }
    }

    /**
     * Deals a card to the next player from the game's deck
     */
    public void dealCardToPlayer() {
        // Take first card from the game's deck
        Card c = this.deck.get(0);
        this.deck.remove(0);
        Player p = this.players.get(this.next_player);
        p.giveCard(c);
        p.setScore(this.scoreCalc.getHandValue(p.getHand()));

        // check if player bust
        if (p.getScore() > 21) {
            p.setState(GamePlayer.STATE_GAME_BUST);
            p.getAction().set(ActionValidator.ACTION_STAND);
        }

        System.out.println("Card dealt to *" + p.getName() + "* is: " + c.getId() + c.getSuit()
                + " [Score: " + this.scoreCalc.getHandValue(p.getHand()) + "]");
    }

    /**
     * Deals a card to the game's dealer
     */
    public void dealCardToDealer() {
        Card c = this.deck.get(0);
        this.deck.remove(0);
        this.dealer.giveCard(c);
        this.dealer.setScore(this.scoreCalc.getHandValue(this.dealer.getHand()));

        // check if dealer bust
        if (this.dealer.getScore() > 21 && !this.dealer.getScore().equals(ScoreCalculator.blackJack)) {
            this.dealer.setState(GamePlayer.STATE_GAME_BUST);
            this.dealer.getAction().set(ActionValidator.ACTION_STAND);
        }

        System.out.println("Card dealt to *DEALER* is: " + c.getId() + c.getSuit()
                + " [Score: " + this.scoreCalc.getHandValue(this.dealer.getHand()) + "]");
    }

    /**
     * Deals initial cards to the players and the dealer
     */
    public void startGame() {
        // start with a clean deck
        resetDeck();
        // shuffle a deck
        this.deck = this.dealer.shuffleDeck(this.deck);

        // CLEAR all cards & RESET STATES
        for (Player p : this.players) {
            p.clearHand();
            p.setState(GamePlayer.STATE_GAME);
            p.getAction().set("none");
        }
        this.dealer.clearHand();
        this.dealer.setState(GamePlayer.STATE_GAME);
        this.dealer.getAction().set("none");

        // DEAL cards to PLAYERS (1)
        for (int i = 0; i < this.players.size(); i ++ ) {
            this.dealCardToPlayer();
            this.nextPlayer();
        }
        // DEAL one card to DEALER
        this.dealCardToDealer();

        // DEAL cards to PLAYERS (2)
        for (int i = 0; i < this.players.size(); i ++ ) {
            this.dealCardToPlayer();
            this.nextPlayer();
        }
    }

    /**
     * Deals cards to the dealer until they reach score of 17 or more points
     */
    public void dealerAction() {
        int score = this.scoreCalc.getHandValue(this.dealer.getHand());
        this.dealer.setScore(score);
        while (score < 17) {
            this.dealCardToDealer();
            score = this.scoreCalc.getHandValue(this.dealer.getHand());
            this.dealer.setScore(score);
        }
        this.dealer.getAction().set(ActionValidator.ACTION_STAND);

        // check if bust
        if (score > 21 && score != ScoreCalculator.blackJack) {
            this.dealer.setState(GamePlayer.STATE_GAME_BUST);
        }
    }

    /**
     * Prints out the table view (dealer's and players' hands)
     */
    public void printHands() {
        System.out.println("\n*** Table view ***");
        String dealer_hand = "Dealer has:";
        for (Card c : this.dealer.getHand()) {
            dealer_hand = dealer_hand.concat(" " + c.getId() + c.getSuit());
        }
        System.out.println(dealer_hand + " [Score: "
                + this.scoreCalc.getHandValue(this.dealer.getHand()) + "]");
        for (Player p : this.players) {
            String p_hand = "Player *" + p.getName() + "* has:";
            for (Card c : p.getHand()) {
                p_hand = p_hand.concat(" " + c.getId() + c.getSuit());
            }
            System.out.println(p_hand + " [Score: "
                    + this.scoreCalc.getHandValue(p.getHand()) + "]");
        }
        System.out.println(" ");
    }

    public Dealer getDealer() {
        return this.dealer;
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }
}
