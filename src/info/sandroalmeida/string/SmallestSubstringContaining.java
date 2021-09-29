package info.sandroalmeida.string;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubstringContaining {

    public static String smallestSubstringContaining(String bigString, String smallString) {

        Map<Character, Integer> smallCharMap = new HashMap<>();
        for(char c: smallString.toCharArray()){
            if(smallCharMap.containsKey(c))
                smallCharMap.put(c, smallCharMap.get(c) + 1);
            else
                smallCharMap.put(c, 1);
        }

        int left = 0, right = 0;
        char[] chars = bigString.toCharArray();
        Map<Character, Integer> bigCharMap = new HashMap<>();
        int minSum = Integer.MAX_VALUE;
        int[] minIndicesPair = new int[2];

        while(right < chars.length){
            char current = chars[right];
            if(smallCharMap.containsKey(current)){
                if(bigCharMap.containsKey(current))
                    bigCharMap.put(current, bigCharMap.get(current) + 1);
                else
                    bigCharMap.put(current, 1);
            }
            while(isMapEqual(smallCharMap, bigCharMap)){
                if(right - left < minSum){
                    minSum = right - left;
                    minIndicesPair[0] = left;
                    minIndicesPair[1] = right;
                }
                char leftChar = bigString.charAt(left);
                left++;
                if(bigCharMap.containsKey(leftChar)){
                    bigCharMap.put(leftChar, bigCharMap.get(leftChar) - 1);
                }
            }
            right++;
        }

        if(minSum != Integer.MAX_VALUE)
            return bigString.substring(minIndicesPair[0], minIndicesPair[1] + 1);
        else
            return "";
    }

    public static boolean isMapEqual(Map<Character, Integer> smallMap, Map<Character, Integer> bigMap){
        for(Map.Entry<Character, Integer> item: smallMap.entrySet()){
            if(!bigMap.containsKey(item.getKey()) || bigMap.getOrDefault(item.getKey(),0) < item.getValue())
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String bigString = "abzacdwejxjftghiwjtklmnopqrstuvwxyz";
        String smallString = "aajjttwwxxzz";
        String expected = "abzacdwejxjftghiwjtklmnopqrstuvwxyz";
        String result = smallestSubstringContaining(bigString, smallString);
        System.out.println(result.equals(expected));
    }

}
