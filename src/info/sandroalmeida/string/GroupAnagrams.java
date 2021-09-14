package info.sandroalmeida.string;

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(List<String> words) {

        Map<String, List<String>> anagrams = new HashMap<>();
        for(String word: words){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if(anagrams.containsKey(sortedWord)){
                anagrams.get(sortedWord).add(word);
            } else{
                anagrams.put(sortedWord, new ArrayList<>(List.of(word)));
            }
        }
        return new ArrayList<>(anagrams.values());

    }


    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"));
        List<List<String>> result = groupAnagrams(words);
    }

}