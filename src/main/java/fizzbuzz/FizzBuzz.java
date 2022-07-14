package fizzbuzz;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class FizzBuzz {
    public List<String> getNumbers(int from, int until) {
        return IntStream.rangeClosed(from, until).mapToObj(number -> toFizzBuzz(number, () -> {
            if (number % 3 == 0) {
                return "Fizz";
            }
            return "";
        }, () -> {
            if (number % 5 == 0) {
                return "Buzz";
            }
            return "";
        })).collect(Collectors.toList());
    }

    private String toFizzBuzz(int number, Supplier<String> fizzRule, Supplier<String> buzzRule) {
        String result = Stream.of(fizzRule, buzzRule).map(Supplier::get).collect(Collectors.joining());
        if (result.isEmpty()) {
            return Integer.toString(number);
        }
        return result;
    }
}
