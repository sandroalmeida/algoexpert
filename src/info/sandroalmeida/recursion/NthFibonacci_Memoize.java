package info.sandroalmeida.recursion;

import java.util.HashMap;
import java.util.Map;

public class NthFibonacci_Memoize {

    public static int getNthFib(int n) {

        Map<Integer, Integer> memoize = new HashMap<>();
        memoize.put(1, 0);
        memoize.put(2, 1);
        return getNthFib(n, memoize);
    }

    public static int getNthFib(int n, Map<Integer, Integer> memoize){
        if (!memoize.containsKey(n)) {
            memoize.put(n, getNthFib(n - 1, memoize) + getNthFib(n - 2, memoize));
        }
        return memoize.get(n);
    }

    public static void main(String[] args) {
        System.out.println(getNthFib(1));
        System.out.println(getNthFib(2));
        System.out.println(getNthFib(3));
        System.out.println(getNthFib(4));
        System.out.println(getNthFib(5));
        System.out.println(getNthFib(6));
    }
}
