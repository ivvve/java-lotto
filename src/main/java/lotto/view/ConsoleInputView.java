package lotto.view;

import lotto.domain.Lotto;
import lotto.parser.LottoNumberParser;

import java.util.Scanner;

public class ConsoleInputView {
    private ConsoleInputView() {
    }

    public static long inputMoney(Scanner scanner) {
        System.out.println("구입금액을 입력해 주세요.");
        return Long.parseLong(scanner.nextLine());
    }

    public static Lotto inputWinnerNumbers(Scanner scanner) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winnerNumbersString = scanner.nextLine();
        System.out.println();

        return LottoNumberParser.parse(winnerNumbersString);
    }
}