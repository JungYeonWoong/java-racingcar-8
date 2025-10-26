package racingcar.service;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    /**
     * 쉼표(,)를 기준으로 자동차 이름을 구분하여 리스트로 반환
     *
     * @param input 자동차 이름들이 포함된 문자열 (예: "pobi,woni,jun")
     * @return 자동차 이름 리스트
     *
     * 각 이름이 5자 이하인지 검증
     * @throws IllegalArgumentException 입력값이 비어있거나 이름이 5자를 초과했을 때 발생
     */
    public List<String> parseCarNames(String input) {
        // 쉼표 기준으로 분리 후, 공백 제거
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("🚫 입력값이 비어 있습니다.");
        }

        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException(
                        String.format("🚫 자동차 이름 '%s'이(가) 5자를 초과했습니다.", name)
                );
            }
            if (name.isEmpty()) {
                throw new IllegalArgumentException("🚫 빈 이름은 허용되지 않습니다.");
            }
        }


        return carNames;
    }
}
