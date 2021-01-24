package info.sandroalmeida.array;

import java.util.HashSet;
import java.util.Set;

public class FirstDuplicateValue {

    public static int firstDuplicateValue(int[] array) {
        Set<Integer> visitedInt = new HashSet<>();
        for (int i : array) {
            if (visitedInt.contains(i))
                return i;
            visitedInt.add(i);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstDuplicateValue(new int[] {2, 1, 5, 2, 3, 3, 4}));
    }
}
