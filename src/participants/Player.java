package participants;
/* participants.Player object - a client that plays the game
 Author: Vaidas Vaitkevicius
 Date: 18/10/2018
 */

public class Player extends GamePlayer {

    private String name;
    private Float balance;
    private Float stake;

    /**
     * participants.Player constructor
     *
     * @param name participants.Player's name
     * @param balance participants.Player's initial balance
     */
    public Player(String name, Float balance) {
        super();
        this.name = name;
        this.balance = balance;
    }

    /**
     * Updates player's balance (either adds or subtracts provided amount)
     *
     * @param difference money to be added/taken away from the balance (can be positive/negative integer)
     */
    public void updateBalance(Float difference) {
        System.out.println(this.name + " current balance is: " + this.balance);
        this.balance += difference;
        System.out.println(this.name + " balance updated to: " + this.balance);
    }

    /**
     * Gets player's balance
     * @return Player's balance
     */
    public Float getBalance() {
        return this.balance;
    }

    public void setStake(Float stake) {
        this.stake = stake;
        this.updateBalance(-stake);
    }

    public Float getStake() {
        return this.stake;
    }

    public String getName() {
        return this.name;
    }
}
