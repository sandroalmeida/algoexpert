package info.sandroalmeida.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZizzagTraverse {

    public static List<Integer> zigzagTraverse(List<List<Integer>> array){

        int height = array.size() - 1;
        int width = array.get(0).size() - 1;
        List<Integer> result = new ArrayList<>();
        int row = 0;
        int col = 0;
        boolean goingDown = true;
        while(!isOutOfBounds(row, col, height, width)){
            result.add((array.get(row).get(col)));
            if(goingDown){
                if(col == 0 || row == height){
                    goingDown = false;
                    if(row == height){
                        col++;
                    } else{
                        row++;
                    }
                } else{
                    row++;
                    col--;
                }
            } else{
                if(row == 0 || col == width){
                    goingDown = true;
                    if(col == width) {
                        row++;
                    } else{
                        col++;
                    }
                } else{
                    row--;
                    col++;
                }
            }
        }
        return result;
    }

    public static boolean isOutOfBounds(int row, int col, int height, int width) {
        return row < 0 || row > height || col < 0 || col > width;
    }

    public static void main(String[] args) {
        List<List<Integer>> test = new ArrayList<>();
        test.add(new ArrayList<>(Arrays.asList(1, 3, 4, 10)));
        test.add(new ArrayList<>(Arrays.asList(2, 5, 9, 11)));
        test.add(new ArrayList<>(Arrays.asList(6, 8, 12, 15)));
        test.add(new ArrayList<>(Arrays.asList(7, 13, 14, 16)));
        List<Integer> result = zigzagTraverse(test);
        for(int i: result)
            System.out.print(i + " ");

        List<List<Integer>> test2 = new ArrayList<>();
        test2.add(new ArrayList<>(Arrays.asList(1, 3, 4, 10)));
        List<Integer> result2 = zigzagTraverse(test2);
        for(int i: result2)
            System.out.print(i + " ");
    }
}
