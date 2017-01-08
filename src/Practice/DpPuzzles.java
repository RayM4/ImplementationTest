package Practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Dynamic Programming Problems
 */
public class DpPuzzles {

    //normal fib
    public static int fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    //top down fib
    public static int dpFibonacci(int n) {
        Map<Integer,Integer> fibMap = new HashMap<Integer,Integer>();
        return dpFib(n, fibMap);
    }

    private static int dpFib(int n, Map<Integer,Integer> map) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (map.containsKey(n))
            return map.get(n);
        map.put(n,dpFib(n-1, map)+dpFib(n-2, map));
        return map.get(n);
    }
}
