package lotto.domain;

import lotto.vo.LottoResult;

public class LottoChecker {
    private LottoChecker() {
    }

    public static LottoResult getResult(Lotto winner, LottoBundle lottoBundle) {
        return new LottoResult(getMatchCounts(winner, lottoBundle));
    }

    static long[] getMatchCounts(Lotto winner, LottoBundle lottoBundle) {
        long[] result = new long[Lotto.TOTAL_LOTTO_NUMBERS + 1];

        lottoBundle.getLottos().forEach(lotto -> {
            int numberOfDuplicatedNumbers = lotto.getNumberOfDuplicatedNumbers(winner);
            result[numberOfDuplicatedNumbers]++;
        });

        return result;
    }
}