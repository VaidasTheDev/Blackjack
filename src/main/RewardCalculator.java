package main;
/* Reward calculator - calculates winnings of a player
 Author: Vaidas Vaitkevicius
 Date: 19/10/2018
 */

import participants.Dealer;
import participants.GamePlayer;
import participants.Player;

import java.util.ArrayList;

public class RewardCalculator {

    /**
     * Empty constructor
     */
    public RewardCalculator() {

    }

    /**
     * Calculates a multiplier by which player's stake should be multiplied
     * to give total reward value ('stake' x 'multiplier')
     * @param score Player's hand score
     * @return Stake multiplier
     */
    public Float calculate(Integer score) {
        if (score.equals(ScoreCalculator.blackJack)) {
            return 2.5f;
        } else {
            return 2.0f;
        }
    }

    public void processWinnings(Dealer dealer, ArrayList<Player> players) {
        if (dealer.getState().equals(GamePlayer.STATE_GAME_BUST)) {
            for (Player p : players) {
                if (!p.getState().equals(GamePlayer.STATE_GAME_BUST)) {
                    Float multiplier = this.calculate(p.getScore());
                    Float winnings = p.getStake() * multiplier;
                    System.out.println(p.getName() + " wins: " + winnings);
                    p.updateBalance(winnings);
                } else {
                    System.out.println(p.getName() + " loses: " + p.getStake());
                }
            }
        } else {
            for (Player p : players) {
                if (p.getState().equals(GamePlayer.STATE_GAME_BUST)) {
                    // loses
                    System.out.println(p.getName() + " loses: " + p.getStake());
                } else {
                    if (p.getScore() > dealer.getScore()) {
                        // wins
                        Float multiplier = this.calculate(p.getScore());
                        Float winnings = p.getStake() * multiplier;
                        System.out.println(p.getName() + " wins: " + winnings);
                        p.updateBalance(winnings);
                    } else if (p.getScore() < dealer.getScore()) {
                        // loses
                        System.out.println(p.getName() + " loses: " + p.getStake());
                    } else {
                        // draw (pay back the stake)
                        // also, technically a win
                        System.out.println(p.getName() + " wins: " + p.getStake());
                        p.updateBalance(p.getStake());
                    }
                }
            }
        }
    }
}
