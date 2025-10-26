package racingcar.service;

import racingcar.domain.Car;
import java.util.List;

public class WinnerCalculator {

    /**
     * 자동차 리스트 중에서 우승자(가장 멀리 간 자동차들)를 찾아 반환합니다.
     */
    public List<Car> findWinners(List<Car> cars) {
        // 모든 자동차 중 최장 거리 탐색
        int maxDistance = findMaxDistance(cars);

        // 최장 거리와 같은 자동차만 필터링
        return cars.stream()
                .filter(car -> car.isSameDistance(maxDistance))
                .toList();
    }

    /**
     * 가장 멀리 간 자동차의 거리(최대 거리)를 계산합니다.
     */
    private int findMaxDistance(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            max = car.compareDistance(max);
        }
        return max;
    }
}
