package racingcar.view;

import racingcar.domain.Car;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printCarPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.status()); // ✅ getter 대신 Car가 스스로 출력 문자열 제공
        }
        System.out.println();
    }
    /**
     * 공동 우승자가 있는 경우 쉼표로 구분하여 출력합니다.
     * 예: pobi,woni가 최종 우승했습니다.
     */
    public void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::name)
                .collect(Collectors.joining(","));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
