package racingcar.service;

public class InputValidator {
    private static final String EMPTY_INPUT_ERROR = "🚫 입력값이 비어 있습니다.";
    private static final String NOT_NUMBER_ERROR = "🚫 시도 횟수는 숫자여야 합니다.";
    private static final String NOT_POSITIVE_ERROR = "🚫 시도 횟수는 양의 정수여야 합니다.";

    /**
     * 입력된 문자열이 양의 정수인지 검증
     *
     * @param input 경주에 대한 tryCount
     * @return 정수로 변환된 값
     * @throws IllegalArgumentException 양수가 아니거나 정수가 아닐 경우
     */
    public int validateTryCount(String input) {
        validateNotEmpty(input);
        int count = parseToInt(input);
        validatePositive(count);
        return count;
    }

    /**
     * 입력이 비어있는지 검증
     */
    private void validateNotEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }
    }

    /**
     * 문자열을 정수로 변환
     */
    private int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }
    }

    /**
     * 정수가 양수인지 검증
     */
    private void validatePositive(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_ERROR);
        }
    }
}
