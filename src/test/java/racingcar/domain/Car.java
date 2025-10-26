package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    /**
     * 0~9 사이 난수를 입력받아, 4 이상이면 전진
     *
     * @param randomNumber 난수 값
     */
    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }

    /**
     * 자동차의 현재 상태를 문자열로 반환합니다.
     * 예: "pobi : ---"
     */
    public String status() {
        return name + " : " + "-".repeat(position);
    }

}
