package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("자동차 2대가 1회 경주를 정상적으로 수행")
    void 자동차_2대_정상_경주_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("모든 자동차가 동일 거리일 경우 공동 우승 처리")
    void 공동_우승_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "jun : -")
                            .contains("최종 우승자 : pobi,woni,jun");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("여러 라운드를 정상적으로 진행할 수 있다")
    void 다중_라운드_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output())
                            .contains("실행 결과")
                            .contains("pobi : -") // 첫 라운드 이후
                            .contains("최종 우승자");
                },
                MOVING_FORWARD, STOP,  // 1라운드
                MOVING_FORWARD, STOP,  // 2라운드
                STOP, MOVING_FORWARD   // 3라운드
        );
    }

    @Test
    @DisplayName("모든 자동차가 전혀 이동하지 않아도 정상적으로 우승자가 출력된다")
    void 모두_정지_상태_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "2");
                    assertThat(output())
                            .contains("pobi : ")
                            .contains("woni : ")
                            .contains("jun : ")
                            .contains("최종 우승자 : pobi,woni,jun"); // 모두 동일 거리 (0)
                },
                STOP, STOP, STOP, STOP, STOP, STOP
        );
    }

    @Test
    @DisplayName("이름이 동일한 자동차가 있어도 정상적으로 처리된다")
    void 중복_이름_자동차_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ")
                            .contains("최종 우승자 : pobi"); // 첫 번째 pobi만 전진
                },
                MOVING_FORWARD, STOP, STOP
        );
    }


    @Test
    @DisplayName("자동차 이름이 비어있으면 예외 발생")
    void 빈_자동차_이름_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("빈 이름")
        );
    }

    @Test
    @DisplayName("자동차 이름이 완전히 비어있으면 예외 발생")
    void 자동차_이름_완전_빈문자열_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("비어")
        );
    }

    @Test
    @DisplayName("자동차 이름이 공백만 존재할 경우 예외 발생")
    void 자동차_이름_공백문자열_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("   ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("비어")
        );
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외 발생")
    void 이름_길이_초과_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("5자를 초과")
        );
    }

    @Test
    @DisplayName("자동차 이름이 정확히 5자일 경우 정상 동작 (경계값 테스트)")
    void 이름_길이_정확히5자_정상_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobii,woni", "1");
                    assertThat(output()).contains("pobii : -", "woni : ")
                            .contains("최종 우승자 : pobii");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("시도 횟수가 0 또는 음수일 경우 예외 발생")
    void 시도_횟수_음수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("양의 정수")
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-2"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("양의 정수")
        );
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아니면 예외 발생")
    void 시도_횟수_숫자아님_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "abc"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("숫자")
        );
    }

    @Test
    @DisplayName("시도 횟수가 공백일 경우 예외 발생")
    void 시도_횟수_공백_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", " "))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("비어")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
