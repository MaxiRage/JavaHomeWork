import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    public void testCalculateDiscount() {

        Calculator calculator = new Calculator();

        // Тест 1: проверка корректного расчета скидки
        double result1 = calculator.calculateDiscount(100.0, 10.0);
        assertThat(result1).isEqualTo(90.0);

        // Тест 2: проверка расчета скидки для суммы покупки равной 0
        double result2 = calculator.calculateDiscount(0.0, 20.0);
        assertThat(result2).isEqualTo(0.0);


        // Тест 3: проверка выброса исключения при отрицательной сумме покупки
        assertThatThrownBy(() -> calculator.calculateDiscount(-100.0, 15.0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Invalid arguments");


        // Тест 4: проверка выброса исключения при отрицательном проценте скидки
        assertThatThrownBy(() -> calculator.calculateDiscount(200.0, -10.0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Invalid arguments");

        // Тест 5: проверка выброса исключения при проценте скидки больше 100
        assertThatThrownBy(() -> calculator.calculateDiscount(150.0, 120.0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Invalid arguments");
    }
}
