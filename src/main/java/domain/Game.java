package domain;

import java.util.List;

public class Game {

    private final List<Player> players;
    private final Deck deck;
    private final Dealer dealer;

    public Game(List<Player> players, Deck deck, Dealer dealer) {
        this.players = players;
        this.deck = deck;
        this.dealer = dealer;
    }

    public void dealCards() {
        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
                player.addCard(deck.drawCard());
            }
        }
    }

    public boolean isWon(int index) {
        Player player = players.get(index);

        if (player.getScore() > dealer.getScore() || dealer.isBusted()) {
            return true;
        }

        return false;
    }
}
