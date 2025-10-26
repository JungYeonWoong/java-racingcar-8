package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    /**
     * 자동차 이름 입력을 콘솔로부터 받습니다.
     *
     * @return 입력받은 문자열 (예: "pobi,woni,jun")
     */
    public String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();

        return carNamesInput;
    }
}