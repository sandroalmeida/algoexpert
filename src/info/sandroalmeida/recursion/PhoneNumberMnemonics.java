package info.sandroalmeida.recursion;

import java.util.*;

public class PhoneNumberMnemonics {

    public static ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        Map<Character, List<Character>> charsMap = new HashMap<>();
        charsMap.put('2', new ArrayList<>(Arrays.asList('a','b','c')));
        charsMap.put('3', new ArrayList<>(Arrays.asList('d','e','f')));
        charsMap.put('4', new ArrayList<>(Arrays.asList('g','h','i')));
        charsMap.put('5', new ArrayList<>(Arrays.asList('j','k','l')));
        charsMap.put('6', new ArrayList<>(Arrays.asList('m','n','o')));
        charsMap.put('7', new ArrayList<>(Arrays.asList('p','q','r','s')));
        charsMap.put('8', new ArrayList<>(Arrays.asList('t','u','v')));
        charsMap.put('9', new ArrayList<>(Arrays.asList('w','x','y','z')));
        ArrayList<String> result = new ArrayList<>();
        helper(phoneNumber, result, charsMap, 0, "");
        return result;
    }

    public static void helper
            (String phoneNumber, ArrayList<String> result, Map<Character, List<Character>> charsMap, int index, String currentStr){
        char element = phoneNumber.charAt(index);
        if(element != '1' && element != '0'){
            List<Character> letters = charsMap.get(element);
            for(char c: letters){
                if(index == phoneNumber.length() -  1)
                    result.add(currentStr + c);
                else
                    helper(phoneNumber, result, charsMap, index + 1, currentStr + c);
            }
        } else{
            if(index == phoneNumber.length() -  1)
                result.add(currentStr + element);
            else
                helper(phoneNumber, result, charsMap, index + 1, currentStr + element);
        }
    }

    public static void main(String[] args) {
        List<String> result = phoneNumberMnemonics("1905");
        for(String str: result)
            System.out.println(str);
    }
}
