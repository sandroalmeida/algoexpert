package info.sandroalmeida.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * matrix =
 * [
 *   [1, 0, 0, 0, 0, 0],
 *   [0, 1, 0, 1, 1, 1],
 *   [0, 0, 1, 0, 1, 0],
 *   [1, 1, 0, 0, 1, 0],
 *   [1, 0, 1, 1, 0, 0],
 *   [1, 0, 0, 0, 0, 1],
 * ]
 *
 * [
 *   [1, 0, 0, 0, 0, 0],
 *   [0, 0, 0, 1, 1, 1],
 *   [0, 0, 0, 0, 1, 0],
 *   [1, 1, 0, 0, 1, 0],
 *   [1, 0, 0, 0, 0, 0],
 *   [1, 0, 0, 0, 0, 1],
 * ]
 *  The islands that were removed can be clearly seen here:
 *  [
 *    [ ,  ,  ,  ,  , ],
 *    [ , 1,  ,  ,  , ],
 *    [ ,  , 1,  ,  , ],
 *    [ ,  ,  ,  ,  , ],
 *    [ ,  , 1, 1,  , ],
 *    [ ,  ,  ,  ,  , ],
 *  ]
 * */

public class RemoveIslands {

    public static int[][] removeIslands(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(visited[i][j])
                    continue;
                traverse(matrix, visited, i, j);
            }
        }
        return matrix;
    }

    public static void traverse(int[][] matrix, boolean[][] visited, int i, int j){

        List<Integer[]> islandPoints = new ArrayList<>();
        Stack<Integer[]> stack = new Stack<>();
        stack.add(new Integer[]{i, j});
        boolean touchBorder = false;

        while(!stack.isEmpty()){
            Integer[] current = stack.pop();
            i = current[0];
            j = current[1];
            int currentValue = matrix[i][j];

            if(currentValue == 0 || visited[i][j])
                continue;

            visited[i][j] = true;

            if(i == 0 || i == matrix.length - 1 || j == 0 || j == matrix[0].length - 1){
                touchBorder = true;
            }
            islandPoints.add(new Integer[]{i, j});
            List<Integer[]> neighbors = getNeighbors(matrix, visited, i, j);
            stack.addAll(neighbors);
        }
        if(!touchBorder){
            for(Integer[] points: islandPoints)
                matrix[points[0]][points[1]] = 0;
        }
    }
    public static List<Integer[]> getNeighbors(int[][] matrix, boolean[][] visited, int i, int j){
        List<Integer[]> neighbors = new ArrayList<>();
        //left
        if(j + 1 < matrix[0].length && !visited[i][j + 1])
            neighbors.add(new Integer[]{i, j + 1});
        //right
        if(j - 1 > 0 && !visited[i][j - 1])
            neighbors.add(new Integer[]{i, j - 1});
        //up
        if(i + 1 < matrix.length && !visited[i + 1][j])
            neighbors.add(new Integer[]{i + 1, j});
        //down
        if(i - 1 > 0 && !visited[i - 1][j])
            neighbors.add(new Integer[]{i - 1, j});
        return neighbors;
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {
                                        {1, 0, 0, 0, 0, 0},
                                        {0, 1, 0, 1, 1, 1},
                                        {0, 0, 1, 0, 1, 0},
                                        {1, 1, 0, 0, 1, 0},
                                        {1, 0, 1, 1, 0, 0},
                                        {1, 0, 0, 0, 0, 1},
                                    };
        int[][] expected = new int[][] {
                                            {1, 0, 0, 0, 0, 0},
                                            {0, 0, 0, 1, 1, 1},
                                            {0, 0, 0, 0, 1, 0},
                                            {1, 1, 0, 0, 1, 0},
                                            {1, 0, 0, 0, 0, 0},
                                            {1, 0, 0, 0, 0, 1},
                                    };
        removeIslands(input);
        boolean check = true;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if(input[i][j] == expected[i][j])
                    continue;
                else
                    check = false;
            }
        }
        System.out.println("Result is " + check);
    }
}
