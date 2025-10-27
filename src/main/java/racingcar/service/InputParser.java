package racingcar.service;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String EMPTY_INPUT_ERROR = "🚫 입력값이 비어 있습니다.";
    private static final String EMPTY_NAME_ERROR = "🚫 빈 이름은 허용되지 않습니다.";
    private static final String NAME_LENGTH_ERROR = "🚫 자동차 이름 '%s'이(가) 5자를 초과했습니다.";

    /**
     * 쉼표(,)를 기준으로 자동차 이름을 구분하여 리스트로 반환
     */
    public List<String> parseCarNames(String input) {
        validateInputNotEmpty(input);

        List<String> carNames = splitAndTrim(input);
        validateCarNames(carNames);

        return carNames;
    }

    /**
     * 입력값이 비어있는지 검증
     */
    private void validateInputNotEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }
    }

    /**
     * 쉼표 기준으로 분리 후 공백 제거
     */
    private List<String> splitAndTrim(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
    }

    /**
     * 각 이름의 길이와 빈 문자열 여부 검증
     */
    private void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            validateNameNotEmpty(name);
            validateNameLength(name);
        }
    }

    private void validateNameNotEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(NAME_LENGTH_ERROR, name));
        }
    }
}
