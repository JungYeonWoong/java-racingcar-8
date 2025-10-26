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

    /**
     * 경주 진행 횟수를 콘솔로부터 입력받음
     *
     * @return 사용자가 입력한 이동 횟수 문자열
     */
    public String readRacingCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCount = Console.readLine();
        return tryCount;
    }
}