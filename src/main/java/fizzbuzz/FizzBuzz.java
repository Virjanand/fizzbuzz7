package fizzbuzz;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FizzBuzz {
    public List<String> getNumbers(int from, int until) {
        return IntStream.rangeClosed(from, until).mapToObj(number -> toFizzBuzz(number, Stream.of(number1 -> {
            if (number1 % 3 == 0) {
                return "Fizz";
            }
            return "";
        }, number1 -> {
            if (number1 % 5 == 0) {
                return "Buzz";
            }
            return "";
        }))).collect(Collectors.toList());
    }

    private String toFizzBuzz(int number, Stream<Function<Integer, String>> rules) {
        String result = rules.map(rule -> rule.apply(number)).collect(Collectors.joining());
        if (result.isEmpty()) {
            return Integer.toString(number);
        }
        return result;
    }
}
