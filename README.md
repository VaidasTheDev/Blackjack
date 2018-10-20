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
> ⋅⋅⋅ Action Hit: player is dealt a card, and asked to choose next action
> ⋅⋅⋅ Action Stand: dealer is dealt cards until hand score reaches 17 (dealer stands on Soft Ace)
> ⋅⋅⋅ Scores are calculated, compared and if player is a winner, reward is given
> ⋅⋅⋅ Reward: 2.0 x stake (if blackjack: 2.5 x stake)

> ### Flaws
> ⋅⋅⋅ No data is saved (no database implementation)
> ⋅⋅⋅ Console-based game (no User Interface implementation)
> ⋅⋅⋅ Code isn't optimised (has warnings, game-logic isn't optimised)
