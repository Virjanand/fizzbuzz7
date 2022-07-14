package fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @BeforeEach
    void createFizzBuzz() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    void get100Numbers() {
        assertThat(fizzBuzz.getNumbers(1, 100)).hasSize(100);
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource(
            {
                    "3, Fizz",
                    "5, Buzz",
                    "6, Fizz",
                    "10, Buzz",
                    "15, FizzBuzz",
            }
    )
    void replaceNumberwithFizzBuzz(int number, String fizzBuzzString) {
        assertThat(fizzBuzz.getNumbers(1, 100).get(number - 1)).isEqualTo(fizzBuzzString);
    }
}
