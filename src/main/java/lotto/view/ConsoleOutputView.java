package lotto.view;

import lotto.domain.LottoBundle;
import lotto.domain.LottoMachine;
import lotto.domain.LottoProfitCalculator;
import lotto.enums.LottoRank;
import lotto.vo.LottoResult;

public class ConsoleOutputView {
    private ConsoleOutputView() {
    }

    public static void printNumberOfAffordableLottos(long money) {
        long numberOfAffordableLottos = LottoMachine.getNumberOfAffordableLottos(money);
        System.out.println(numberOfAffordableLottos + "개를 구매했습니다.");
    }

    public static void printLottos(LottoBundle lottoBundle) {
        lottoBundle.getLottos().forEach(lotto ->
            System.out.println(lotto.getNumbers())
        );

        System.out.println();
    }

    public static void printWinStatistics(long cost, LottoResult lottoResult) {
        String format = "%d개 일치 (%,d원) - %d개%n";

        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.printf(format,
                LottoRank.FOURTH.getMatchCount(), LottoRank.FOURTH.getPrizeMoney(), lottoResult.getFourth());
        System.out.printf(format,
                LottoRank.THIRD.getMatchCount(), LottoRank.THIRD.getPrizeMoney(), lottoResult.getThird());
        System.out.printf(format,
                LottoRank.SECOND.getMatchCount(), LottoRank.SECOND.getPrizeMoney(), lottoResult.getSecond());
        System.out.printf(format,
                LottoRank.FIRST.getMatchCount(), LottoRank.FIRST.getPrizeMoney(), lottoResult.getFirst());

        double totalProfitRate = LottoProfitCalculator.getTotalProfitRate(cost, lottoResult);
        printTotalProfitRate(totalProfitRate);
    }

    private static void printTotalProfitRate(double totalProfitRate) {
        System.out.printf("총 수익률은 %,.2f입니다.%n", totalProfitRate);
    }
}
