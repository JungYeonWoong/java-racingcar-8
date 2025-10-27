package racingcar;

import racingcar.controller.RacingGame;
import racingcar.domain.Car;
import racingcar.service.InputParser;
import racingcar.service.InputValidator;
import racingcar.service.RandomNumberGenerator;
import racingcar.service.WinnerCalculator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputParser parser = new InputParser();
        InputValidator validator = new InputValidator();
        RandomNumberGenerator rng = new RandomNumberGenerator();
        WinnerCalculator winnerCalculator = new WinnerCalculator();

        // 자동차 이름 입력
        String carInput = inputView.readCarNames();
        List<String> carNames = parser.parseCarNames(carInput);
        List<Car> cars = carNames.stream().map(Car::new).toList();

        // 시도 횟수 입력
        String tryCountInput = inputView.readRaceCount();
        int tryCount = validator.validateTryCount(tryCountInput);

        // 게임 실행
        RacingGame racingGame = new RacingGame(cars, rng, winnerCalculator, outputView);
        racingGame.start(tryCount);
    }
}