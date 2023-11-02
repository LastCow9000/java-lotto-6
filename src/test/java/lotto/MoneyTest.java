package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @DisplayName("money가 null이나 빈 값이면 예외 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void validateNullOrEmptyTest(String input) {
        // when, then
        assertThatThrownBy(() -> new Money(input))
                .hasMessage("[ERROR] 공백이나 빈 값으로는 로또 구매가 불가능합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("money가 숫자가 아닌 값이면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"돈", "money", "10p"})
    void validateNanTest(String input) {
        // when, then
        assertThatThrownBy(() -> new Money(input))
                .hasMessage("[ERROR] 숫자가 아닌 값은 입력이 불가능합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }
}
