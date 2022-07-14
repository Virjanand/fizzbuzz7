package fizzbuzz;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {
    public List<String> getNumbers(int from, int until) {
        return IntStream.rangeClosed(from, until).mapToObj(number -> toFizzBuzz(number, result1 -> {
            if (number % 3 == 0) {
                result1 = "Fizz";
            }
            return result1;
        })).collect(Collectors.toList());
    }

    private String toFizzBuzz(int number, Function<String, String> fizzRule) {
        String result = "";
        result = fizzRule.apply(result);
        if (number % 5 == 0) {
            result += "Buzz";
        }
        if (result.isEmpty()) {
            return Integer.toString(number);
        }
        return result;
    }
}
