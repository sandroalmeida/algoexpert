package info.sandroalmeida.graph;

import java.util.ArrayList;
import java.util.List;

public class SingleCycleCheck {

    public static boolean hasSingleCycle(int[] array) {

        List<Integer> indexesVisited = new ArrayList<>();
        int index = 0;

        while(indexesVisited.size() < array.length + 1){
            if(indexesVisited.contains(index) && indexesVisited.size() < array.length)
                return false;
            indexesVisited.add(index);
            index = getNextIndex(index, array);
        }

        return indexesVisited.get(indexesVisited.size() - 1) == 0;
    }

    public static int getNextIndex(int currentIndex, int[] array){
        int jump = array[currentIndex];
        int nextIndex = (currentIndex + jump) % array.length;
        return nextIndex >= 0 ? nextIndex : nextIndex + array.length;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, -2, 3, 7, 8, -26};
        System.out.println(hasSingleCycle(array));
    }
}
