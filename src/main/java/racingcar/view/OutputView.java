package racingcar.view;

import racingcar.domain.Car;
import java.util.List;

public class OutputView {

    public void printCarPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.status()); // ✅ getter 대신 Car가 스스로 출력 문자열 제공
        }
        System.out.println();
    }
}
