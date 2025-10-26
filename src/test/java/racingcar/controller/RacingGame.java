package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.RandomNumberGenerator;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final RandomNumberGenerator randomNumberGenerator;
    private final OutputView outputView;

    public RacingGame(List<Car> cars, RandomNumberGenerator randomNumberGenerator, OutputView outputView) {
        this.cars = cars;
        this.randomNumberGenerator = randomNumberGenerator;
        this.outputView = outputView;
    }

    /**
     * 지정된 횟수만큼 경주를 진행
     *
     * @param tryCount 라운드(시도) 횟수
     */
    public void start(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            playOneRound();
        }
    }

    /**
     * 1라운드를 진행합니다.
     */
    private void playOneRound() {
        for (Car car : cars) {
            int randomNumber = randomNumberGenerator.generateRandomNumber();
            car.move(randomNumber);
        }
        outputView.printCarPosition(cars);
    }
}
