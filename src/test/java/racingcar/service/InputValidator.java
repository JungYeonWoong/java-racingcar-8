package racingcar.service;

public class InputValidator {

    /**
     * 입력된 문자열이 양의 정수인지 검증
     *
     * @param input 경주에 대한 tryCount
     * @return 정수로 변환된 값
     * @throws IllegalArgumentException 양수가 아니거나 정수가 아닐 경우
     */
    public int validateTryCount(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("🚫 입력값이 비어 있습니다.");
        }

        try {
            int count = Integer.parseInt(input);
            if (count <= 0) {
                throw new IllegalArgumentException("🚫 시도 횟수는 양의 정수여야 합니다.");
            }
            return count;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("🚫 시도 횟수는 숫자여야 합니다.");
        }
    }
}