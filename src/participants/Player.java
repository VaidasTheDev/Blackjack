package participants;
/* participants.Player object - a client that plays the game
 Author: Vaidas Vaitkevicius
 Date: 18/10/2018
 */

public class Player extends GamePlayer {

    private String name;
    private String username;
    private String password;
    private Float balance;
    private Float stake;

    /**
     * participants.Player constructor
     *
     * @param name participants.Player's name
     * @param balance participants.Player's initial balance
     */
    public Player(String name, String username, String password, Float balance) {
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

    /**
     * Sets player's stake for the upcoming game
     * @param stake stake
     */
    public void setStake(Float stake) {
        this.stake = stake;
        this.updateBalance(-stake);
    }

    /**
     * Retrieves player's stake (wager)
     * @return stake
     */
    public Float getStake() {
        return this.stake;
    }

    /**
     * Retrieves player's name
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Retrieves player's username
     * @return username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Retrieves player's password
     * @return password
     */
    public String getPassword() {
        return this.password;
    }
}
