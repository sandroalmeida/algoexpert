package info.sandroalmeida.string;

import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {

    public static boolean generateDocument(String characters, String document) {

        Map<Character, Integer> characterMap = new HashMap<>();
        for(char c: characters.toCharArray()){
            if(characterMap.containsKey(c))
                characterMap.put(c, characterMap.get(c) + 1);
            else
                characterMap.put(c, 1);
        }
        for(char c: document.toCharArray()){
            if(characterMap.containsKey(c)){
                int qty = characterMap.get(c);
                if(qty == 1)
                    characterMap.remove(c);
                else
                    characterMap.put(c, characterMap.get(c) - 1);
            } else{
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String characters = "Bste!hetsi ogEAxpelrt x ";
        String document = "AlgoExpert is the Best!";
        System.out.println(generateDocument(characters, document));
    }
}
