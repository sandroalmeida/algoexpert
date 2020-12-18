package info.sandroalmeida.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {

    public static List<Integer> spiralTraverse(int[][] array) {

        List<Integer> result = new ArrayList<>();
        int startRow = 0, endRow = array.length - 1;
        int startCol = 0, endCol = array[0].length - 1;

        while(startRow <= endRow && startCol <= endCol){

            // superior border
            for(int i = startCol; i <= endCol; i++)
                result.add(array[startRow][i]);

            // right border
            for(int i = startRow + 1; i <= endRow; i++)
                result.add(array[i][endCol]);

            // inferior border
            for(int i = endCol - 1; i >= startCol; i--){
                if(startRow == endRow) break;
                result.add(array[endRow][i]);
            }

            // left border
            for(int i = endRow - 1; i > startRow; i--){
                if(startCol == endCol) break;
                result.add(array[i][startCol]);
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] array = {{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
        int[][] array2 = {{1, 2, 3, 4}, {10, 11, 12, 5}, {9, 8, 7, 6}};
        int[][] array3 = {{1, 2, 3}, {12, 13, 4}, {11, 14, 5}, {10, 15, 6}, {9, 8, 7}};
        System.out.println(spiralTraverse(array));
        System.out.println(spiralTraverse(array2));
        System.out.println(spiralTraverse(array3));
    }
}
