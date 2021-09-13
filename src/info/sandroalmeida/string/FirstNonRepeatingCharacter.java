package info.sandroalmeida.string;

import java.util.*;

public class FirstNonRepeatingCharacter {

    public static int firstNonRepeatingCharacter(String string) {
        Map<Character, Integer> charMap = new HashMap<>();
        char[] chars = string.toCharArray();

        for (char c : chars) {
            if (charMap.containsKey(c))
                charMap.put(c, charMap.get(c) + 1);
            else
                charMap.put(c, 1);
        }

        for(int i = 0; i < chars.length; i++){
            if(charMap.get(chars[i]) == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingCharacter("abcdcafb"));
    }
}
