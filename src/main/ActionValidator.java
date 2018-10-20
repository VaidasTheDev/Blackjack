package main;
/* Action validator - makes sure player's action is a valid action
 Author: Vaidas Vaitkevicius
 Date: 15/10/2018
 */

import java.util.ArrayList;

public class ActionValidator {

    public static String ACTION_HIT = "hit";
    public static String ACTION_STAND = "stand";
    private ArrayList<String> actions;
    /**
     * Constructor
     */
    public ActionValidator() {
        this.actions = new ArrayList<>();
        this.actions.add(ACTION_HIT);
        this.actions.add(ACTION_STAND);
    }

    /**
     * Ensures given action is valid action
     * @param action Action in String format
     * @return true/false depending on whether action is valid or invalid, respectively
     */
    public boolean isValid(String action) {
        return this.actions.contains(action);
    }
}
