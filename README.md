# Blackjack

## Version 1.0
The game can be played between one player and dealer (computer) through 'main' console.

> ### Functionalities
> + Single-player (player vs. computer)
> + Supported player actions: hit, stand
> + Player has a money balance
> + Game-flow:  
> &nbsp;Player enters a stake/wager (through console)  
> &nbsp;Player and dealer are dealt cards. Cards are dealt to the GamePlayers in this order: player, dealer, player  
> &nbsp;Player chooses their action (hit/stand)  
> &nbsp;Action Hit: player is dealt a card, and asked to choose next action  
> &nbsp;Action Stand: dealer is dealt cards until hand score reaches 17 (dealer stands on Soft Ace)  
> &nbsp;Scores are calculated, compared and if player is a winner, reward is given  
> &nbsp;Reward: 2.0 x stake (if blackjack: 2.5 x stake)  

> ### Flaws
> &nbsp;No data is saved (no database implementation)  
> &nbsp;Console-based game (no User Interface implementation)  
> &nbsp;Code isn't optimised (has warnings, game-logic isn't optimised)  
