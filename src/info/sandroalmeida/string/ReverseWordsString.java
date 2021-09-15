package info.sandroalmeida.string;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsString {

    public static String reverseWordsInString(String string) {

        if(string.equals("")) return string;

        List<String> wordsSorted = new ArrayList<>();
        char[] chars = string.toCharArray();
        StringBuilder possibleWord = new StringBuilder();
        boolean isRealWord = chars[0] != ' ';

        for (char c : chars) {
            if (isRealWord && c == ' ') {
                wordsSorted.add(possibleWord.toString());
                possibleWord = new StringBuilder(c + "");
                isRealWord = false;
            } else if (!isRealWord && c != ' ') {
                wordsSorted.add(possibleWord.toString());
                possibleWord = new StringBuilder(c + "");
                isRealWord = true;
            }
            possibleWord.append(c);
        }
        wordsSorted.add(possibleWord.toString());

        StringBuilder result = new StringBuilder();
        for(int i = wordsSorted.size() - 1; i >= 0; i--)
            result.append(wordsSorted.get(i));

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWordsInString("Facebook is the   company I want to work on"));
    }
}
