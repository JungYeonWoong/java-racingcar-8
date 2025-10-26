package racingcar.service;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    /**
     * 쉼표(,)를 기준으로 자동차 이름을 구분하여 리스트로 반환
     *
     * @param input 자동차 이름들이 포함된 문자열 (예: "pobi,woni,jun")
     * @return 자동차 이름 리스트
     */
    public List<String> parseCarNames(String input) {
        // 쉼표 기준으로 분리 후, 공백 제거
        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        return carNames;
    }
}
