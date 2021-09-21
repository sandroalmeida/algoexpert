package info.sandroalmeida.greedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ClassPhotos {

    public static boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        redShirtHeights.sort(Comparator.comparingInt(a -> a));
        blueShirtHeights.sort(Comparator.comparingInt(a -> a));

        boolean redOnFront;
        if(redShirtHeights.get(0) < blueShirtHeights.get(0))
            redOnFront = true;
        else if(redShirtHeights.get(0) > blueShirtHeights.get(0))
            redOnFront = false;
        else
            return false;

        for(int i = 0; i < redShirtHeights.size(); i++){
            if(redOnFront){
                if(redShirtHeights.get(i) > blueShirtHeights.get(i))
                    return false;
            } else{
                if(blueShirtHeights.get(i) > redShirtHeights.get(i))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> redShirtHeights = new ArrayList<>(Arrays.asList(5, 8, 1, 3, 4));
        ArrayList<Integer> blueShirtHeights = new ArrayList<>(Arrays.asList(6, 9, 2, 4, 5));
        System.out.println(classPhotos(redShirtHeights, blueShirtHeights));
    }
}
