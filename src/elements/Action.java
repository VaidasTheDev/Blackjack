package elements;

import java.util.ArrayList;

public class Action {

    private String action;

    public Action() {
        this.action = "none";
    }

    public void set(String action) {
        this.action = action;
    }

    public String get() {
        return this.action;
    }
}
