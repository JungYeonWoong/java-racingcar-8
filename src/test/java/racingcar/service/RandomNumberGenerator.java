package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    /**
     * 0~9 사이의 무작위 숫자를 생성합니다.
     *
     * @return 무작위 정수 (0~9)
     */
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
