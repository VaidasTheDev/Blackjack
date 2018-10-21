package main;

import database.DbHandler;
import participants.Player;

import java.util.Scanner;

public class main {

    public static void main (String[] args) {
        /*ActionValidator actionValidator = new ActionValidator();
        RewardCalculator rewards = new RewardCalculator();
        Scanner scanner = new Scanner(System.in);
        DbHandler dbHandler = new DbHandler();

        while (true) {
            System.out.println("=== Enter a card ===");
            elements.Card c = new elements.Card(scanner.nextLine());
            int validResult = validator.isCardValid(c);

            if (validResult == 1) {
                System.out.println("Your card is: " + c.getId() + c.getSuit());
                System.out.println("Validation result: valid");
            } else {
                System.out.println("Your card is: " + c.getId() + c.getSuit());
                System.out.println("Validation result: invalid");
            }
        }

        Game game = new Game();
        Player p = new Player("Vaidas", 5000f);
        game.addPlayer(p);

        while (true) {
            System.out.println("\n************************************************\n");
            System.out.println("Your current balance is: " + p.getBalance());
            System.out.println("*** Enter your stake ***");
            float stake = scanner.nextFloat();
            // prevent stake being bigger than player's balance
            while (stake > p.getBalance()) {
                stake = scanner.nextFloat();
            }
            System.out.println("Stake: " + stake);
            p.setStake(stake);

            game.startGame();
            game.printHands();
            System.out.println(p.getAction().get());

            while(!p.getAction().get().equals(ActionValidator.ACTION_STAND)) {
                System.out.println("*** Choose your action ***");
                System.out.println("***    [hit, stand]    ***");

                String action = "none";
                while (!actionValidator.isValid(action)) {
                    action = scanner.nextLine();
                }
                p.getAction().set(action);
                System.out.println("Your action: " + p.getAction().get());

                if (p.getAction().get().equals(ActionValidator.ACTION_HIT)) {
                    game.dealCardToPlayer();
                }
            }

            while(!game.getDealer().getAction().get().equals(ActionValidator.ACTION_STAND)) {
                game.dealerAction();
            }

            rewards.processWinnings(game.getDealer(), game.getPlayers());


            // load up welcome screen
        }*/
    }
}
