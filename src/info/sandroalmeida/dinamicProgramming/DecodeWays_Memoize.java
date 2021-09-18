package info.sandroalmeida.dinamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays_Memoize {

    public static int numDecodings(String s) {
        Map<Integer, Integer> mapHelpers = new HashMap<>();
        return helper(s, s.length(), mapHelpers);
    }

    public static int helper(String str, int size, Map<Integer, Integer> mapHelpers){
        if(size == 0)
            return 1;
        int p = str.length() - size;

        if(str.indexOf(p) == '0')
            return 0;

        if(mapHelpers.containsKey(p))
            return mapHelpers.get(p);

        int result = helper(str, size - 1, mapHelpers);
        if(size >= 2 && Integer.parseInt(str.substring(p, p + 2)) <= 26)
            result += helper(str, size - 2, mapHelpers);

        mapHelpers.put(p, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("216"));
    }

}
