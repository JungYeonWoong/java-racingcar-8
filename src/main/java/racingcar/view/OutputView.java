package racingcar.view;

import racingcar.domain.Car;
import java.util.List;

public class OutputView {

    /**
     * 각 자동차의 현재 상태를 출력
     */
    public void printCarPosition(List<Car> cars) {
        cars.forEach(this::printSingleCarStatus);
        printLineBreak();
    }

    /**
     * 한 자동차의 상태를 출력
     */
    private void printSingleCarStatus(Car car) {
        System.out.println(car.status());
    }

    /**
     * 한 줄 띄우기 (라운드 간 구분)
     */
    private void printLineBreak() {
        System.out.println();
    }

    /**
     * 최종 우승자를 출력
     */
    public void printWinners(List<Car> winners) {
        String winnerNames = buildWinnerNames(winners);
        printWinnerMessage(winnerNames);
    }

    /**
     * 우승자 이름을 쉼표로 구분된 문자열로 생성
     */
    private String buildWinnerNames(List<Car> winners) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            boolean isLast = (i == winners.size() - 1);
            winners.get(i).appendName(sb, isLast);
        }
        return sb.toString();
    }

    /**
     * 우승자 메시지 출력
     */
    private void printWinnerMessage(String winnerNames) {
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
