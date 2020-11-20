package info.sandroalmeida.array;

import java.util.*;

public class ValidateSubsequence {

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence){

        int arrayIndex = 0, sequenceIndex = 0;
        while(arrayIndex < array.size() && sequenceIndex < sequence.size()){
            if(array.get(arrayIndex).equals(sequence.get(sequenceIndex))) {
                sequenceIndex++;
            }
            arrayIndex++;
        }
        return sequenceIndex == sequence.size();
    }

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1, 1, 1, 1, 1);
        List<Integer> sequence = Arrays.asList(1, 1, 1);
        System.out.println(isValidSubsequence(array, sequence));
    }

}
