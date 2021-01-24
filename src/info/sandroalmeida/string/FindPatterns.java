package info.sandroalmeida.string;

import java.util.HashMap;
import java.util.Map;

public class FindPatterns {

    public static void findPatterns(String source, int length){

        int pointer1 = 0, pointer2 = length;
        Map<String, Integer> patternMap = new HashMap<>();

        while(pointer2 <= source.length()){
            String subSession = source.substring(pointer1, pointer2);
            patternMap.put(subSession, patternMap.getOrDefault(subSession, 0) + 1);
            pointer1++;
            pointer2++;
        }

        for(Map.Entry<String, Integer> entry: patternMap.entrySet()){
            if(entry.getValue() > 1)
                System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        findPatterns("zf3kabxcde224lkzf3mabxc51+crsdtzf3nab=", 3);
    }
}
