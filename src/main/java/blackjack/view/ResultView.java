package blackjack.view;

import blackjack.domain.Result;
import blackjack.domain.dto.BlackJackDto;
import blackjack.domain.participant.Participant;

public class ResultView {

    private static final String MESSAGE_HAND_OUT_CARD = "%n딜러와 %s 에게 2장의 카드를 나누었습니다.%n";
    private static final String NAME_DELIMITER = ", ";
    private static final String MESSAGE_SCORE_OVER_21 = "가진 카드의 합이 21을 초과하여 더 이상 카드를 받을 수 없습니다.";
    private static final String MESSAGE_DEALER_NOT_RECEIVE = "딜러는 16이하라 한장의 카드를 더 받았습니다";
    private static final String MESSAGE_DEALER_RECEIVE = "딜러는 17이상이라 카드를 더 받지 않았습니다.";
    private static final String RESULT_DELIMITER = " - 결과: ";
    private static final String MESSAGE_FINAL_REVENUE = "\n## 최종 수익";

    public void showStartingStatus(BlackJackDto blackJackDto) {

        System.out.printf(MESSAGE_HAND_OUT_CARD, String.join(NAME_DELIMITER, getPlayerNames(blackJackDto)));
        System.out.println(blackJackDto.getDealerOpenCard());

        for (Participant player : blackJackDto.getParticipants().getPlayers()) {
            showEachPlayerCurrentStatus(blackJackDto, player);
        }
        System.out.println();
    }

    private String[] getPlayerNames(BlackJackDto blackJackDto) {
        return blackJackDto.getParticipants().getPlayers().stream()
            .map(Participant::getName)
            .toArray(String[]::new);
    }

    public void showEachPlayerCurrentStatus(BlackJackDto blackJackDto, Participant participant) {
        System.out.println(getEachPlayerStatus(blackJackDto, participant));
        if (participant.isOverMaxScore()) {
            System.out.println(MESSAGE_SCORE_OVER_21);
        }
    }

    private String getEachPlayerStatus(BlackJackDto blackJackDto, Participant participant) {
        return blackJackDto.getPlayerCardStatus(participant);
    }

    public void showWhetherDealerReceivedOrNot(Boolean isReceived) {
        System.out.println();
        if (isReceived) {
            System.out.println(MESSAGE_DEALER_NOT_RECEIVE);
            return;
        }
        System.out.println(MESSAGE_DEALER_RECEIVE);
    }

    public void showFinalStatus(BlackJackDto blackJackDto) {
        System.out.println();
        Participant dealer = blackJackDto.getParticipants().getDealer();
        System.out.println(getEachPlayerStatus(blackJackDto, dealer) + RESULT_DELIMITER + dealer.getScore());
        for (Participant player : blackJackDto.getParticipants().getPlayers()) {
            System.out.println(getEachPlayerStatus(blackJackDto, player) + RESULT_DELIMITER + player.getScore());
        }
    }

    public void showResult(BlackJackDto blackJackDto, Result result) {
        System.out.println(MESSAGE_FINAL_REVENUE);
        System.out.println(blackJackDto.getDealerRevenue(result));
        blackJackDto.getPlayersRevenue(result).forEach(System.out::println);
    }
}