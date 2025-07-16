import java.util.HashMap;
import java.util.Map;

public class EjerciciosPD {

    public Long getFibonacci(int n) {
        if (n <= 1)
            return (long) n;
        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }

    public Long getFibonacciPD(int n) {
        Map<Integer, Long> cache = new HashMap<>();
        return getFibonacciPDHelper(n, cache);
    }

    private Long getFibonacciPDHelper(int n, Map<Integer, Long> cache) {
        if (n <= 1)
            return (long) n;

        if (cache.containsKey(n))
            return cache.get(n);

        long value = getFibonacciPDHelper(n - 1, cache) + getFibonacciPDHelper(n - 2, cache);
        cache.put(n, value);
        return value;
    }
}