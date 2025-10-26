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

    /**
     * 현재 자동차의 위치가 주어진 최대 거리보다 멀 경우,
     * 해당 위치를 반환하고 그렇지 않으면 기존 최대 거리를 반환합니다.
     *
     * @param currentMax 현재까지의 최대 거리
     * @return 더 먼 거리 값
     */
    public int compareDistance(int currentMax) {
        if (position > currentMax) {
            return position;
        }
        return currentMax;
    }

    /** 같은 거리인지 비교 */
    public boolean isSameDistance(int distance) {
        return position == distance;
    }

    /** 이름을 외부에서 출력용으로만 접근 */
    public String name() {
        return name;
    }

}
