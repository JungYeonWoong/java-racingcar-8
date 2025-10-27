package racingcar.service;

import racingcar.domain.Car;
import java.util.List;

public class WinnerCalculator {

    /**
     * 가장 멀리 간 자동차(들)를 찾아 반환
     */
    public List<Car> findWinners(List<Car> cars) {
        int maxDistance = findMaxDistance(cars);
        return filterWinnersByDistance(cars, maxDistance);
    }

    /**
     * 자동차 중 가장 멀리 간 거리 계산
     */
    private int findMaxDistance(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            max = car.compareDistance(max);
        }
        return max;
    }

    /**
     * 지정된 거리와 동일한 자동차만 필터링
     */
    private List<Car> filterWinnersByDistance(List<Car> cars, int maxDistance) {
        return cars.stream()
                .filter(car -> car.isSameDistance(maxDistance))
                .toList();
    }
}
