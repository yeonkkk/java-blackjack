package blackjack.domain.card;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HandTest {

    @DisplayName("카드 포함 테스트")
    @Test
    void crate() {
        Hand cards = new Hand();
        assertThat(cards.isContains(CardNumber.ACE)).isFalse();
        cards.add(Card.valueOf(CardShape.CLUB, CardNumber.ACE));
        assertThat(cards.isContains(CardNumber.ACE)).isTrue();
    }

    @DisplayName("스코어 테스트")
    @Test
    void score() {
        Hand cards = new Hand();
        cards.add(Card.valueOf(CardShape.CLUB, CardNumber.ACE));
        cards.add(Card.valueOf(CardShape.CLUB, CardNumber.JACK));
        assertThat(cards.score()).isEqualTo(21);
        cards.add(Card.valueOf(CardShape.CLUB, CardNumber.ACE));
        assertThat(cards.score()).isEqualTo(12);
    }

    @DisplayName("블랙잭 테스트")
    @Test
    void isBlackjack() {
        Hand cards = new Hand();
        cards.add(Card.valueOf(CardShape.CLUB, CardNumber.ACE));
        cards.add(Card.valueOf(CardShape.CLUB, CardNumber.JACK));
        assertThat(cards.isBlackjack()).isTrue();
        cards.add(Card.valueOf(CardShape.CLUB, CardNumber.TEN));
        assertThat(cards.isBlackjack()).isFalse();
    }

    @DisplayName("버스트 테스트")
    @Test
    void isBust() {
        Hand cards = new Hand();
        cards.add(Card.valueOf(CardShape.CLUB, CardNumber.JACK));
        cards.add(Card.valueOf(CardShape.CLUB, CardNumber.JACK));
        assertThat(cards.isBust()).isFalse();
        cards.add(Card.valueOf(CardShape.CLUB, CardNumber.TEN));
        assertThat(cards.isBust()).isTrue();
    }
}