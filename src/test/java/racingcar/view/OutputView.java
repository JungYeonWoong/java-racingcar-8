// src/main/java/racingcar/view/OutputView.java
package racingcar.view;

import racingcar.domain.Car;
import java.util.List;

public class OutputView {

    /**
     * 각 자동차의 이름과 위치를 출력합니다.
     * 예시: pobi : --
     */
    public void printCarStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println(); // 한 라운드 출력 후 줄바꿈
    }
}
