package fizzbuzz;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {
    public List<String> getNumbers(int from, int until) {
        return IntStream.rangeClosed(from, until).mapToObj(number -> toFizzBuzz(number, () -> {
            if (number % 3 == 0) {
                return "Fizz";
            }
            return "";
        })).collect(Collectors.toList());
    }

    private String toFizzBuzz(int number, Supplier<String> fizzRule) {
        String result = fizzRule.get();
        if (number % 5 == 0) {
            result += "Buzz";
        }
        if (result.isEmpty()) {
            return Integer.toString(number);
        }
        return result;
    }
}
