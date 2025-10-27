package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.RandomNumberGenerator;
import racingcar.service.WinnerCalculator;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final RandomNumberGenerator randomNumberGenerator;
    private final WinnerCalculator winnerCalculator;
    private final OutputView outputView;

    public RacingGame(List<Car> cars, RandomNumberGenerator randomNumberGenerator,
                      WinnerCalculator winnerCalculator, OutputView outputView) {
        this.cars = cars;
        this.randomNumberGenerator = randomNumberGenerator;
        this.winnerCalculator = winnerCalculator;
        this.outputView = outputView;
    }

    /**
     * 전체 경주를 시작합니다.
     */
    public void start(int tryCount) {
        repeatRace(tryCount);
        printWinners();
    }

    /**
     * 주어진 횟수만큼 경주를 반복합니다.
     */
    private void repeatRace(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            playOneRound();
        }
    }

    /**
     * 한 라운드를 진행합니다.
     */
    private void playOneRound() {
        moveCars();
        printRoundResult();
    }

    /**
     * 모든 자동차를 한 번 이동시킵니다.
     */
    private void moveCars() {
        for (Car car : cars) {
            moveSingleCar(car);
        }
    }

    /**
     * 개별 자동차를 이동시킵니다.
     */
    private void moveSingleCar(Car car) {
        int randomNumber = randomNumberGenerator.generateRandomNumber();
        car.move(randomNumber);
    }

    /**
     * 현재 라운드 결과를 출력합니다.
     */
    private void printRoundResult() {
        outputView.printCarPosition(cars);
    }

    /**
     * 최종 우승자를 계산하고 출력합니다.
     */
    private void printWinners() {
        List<Car> winners = winnerCalculator.findWinners(cars);
        outputView.printWinners(winners);
    }
}
