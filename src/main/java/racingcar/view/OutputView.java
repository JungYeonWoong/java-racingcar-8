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

    /**
     * 공동 우승자가 있는 경우 쉼표로 구분하여 출력
     */
    public void printWinners(List<Car> winners) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            boolean isLast = (i == winners.size() - 1);
            winners.get(i).appendName(sb, isLast);
        }
        System.out.println("최종 우승자 : " + sb);
    }
}
