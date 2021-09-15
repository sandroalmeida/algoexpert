package info.sandroalmeida.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumCharactersForWords {

    public static char[] minimumCharactersForWords(String[] words) {

        Map<Character, Integer> charTotalMap = new HashMap<>();
        for(String word: words){
            Map<Character, Integer> charWordMap = new HashMap<>();
            for(int i = 0; i < word.length(); i++){
                charWordMap.put(word.charAt(i), charWordMap.getOrDefault(word.charAt(i), 0) + 1);
            }
            for(Map.Entry<Character, Integer> item: charWordMap.entrySet()){
                char key = item.getKey();
                int value = item.getValue();
                if(charTotalMap.containsKey(key))
                    charTotalMap.put(key, Math.max(value, charTotalMap.get(key)));
                else
                    charTotalMap.put(key, value);
            }
        }

        List<Character> finalList = new ArrayList<>();
        for(Map.Entry<Character, Integer> item: charTotalMap.entrySet())
            for(int i = 0; i < item.getValue(); i++){
                finalList.add(item.getKey());
            }

        char[] result = new char[finalList.size()];
        for(int i = 0; i < finalList.size(); i++)
            result[i] = finalList.get(i);

        return result;
    }

    public static void main(String[] args) {
        String[] words = new String[] {"this", "that", "did", "deed", "them!", "a"};
        char[] result = minimumCharactersForWords(words);
    }

}
