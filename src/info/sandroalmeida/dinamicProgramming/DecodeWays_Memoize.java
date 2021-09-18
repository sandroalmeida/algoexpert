package info.sandroalmeida.dinamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays_Memoize {

    public static int numDecodings(String s) {
        Map<String, Integer> mapHelpers = new HashMap<>();
        return helper(s, mapHelpers);
    }

    public static int helper(String str, Map<String, Integer> mapHelpers){
        if(str == null || str.length() == 0) return 0;
        if(str.length() == 1) return 1;

        String subsOne = str.substring(1);
        String subsTwo = str.substring(2);

        int totalOne = mapHelpers.getOrDefault(subsOne, 0);
        int totalTwo = mapHelpers.getOrDefault(subsTwo, 0);
        if(totalOne == 0)
            totalOne = helper(subsOne, mapHelpers);

        int firstTwo = Integer.parseInt(str.substring(0, 2));
        if(firstTwo >= 10 && firstTwo <= 26)
            totalTwo = helper(subsTwo, mapHelpers);

        mapHelpers.put(str, totalOne + totalTwo);
        return totalOne + totalTwo;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("1233"));
    }

}
