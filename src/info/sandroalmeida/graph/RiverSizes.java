package info.sandroalmeida.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//INPUT
//matrix = [
//        [1, 0, 0, 1, 0],
//        [1, 0, 1, 0, 0],
//        [0, 0, 1, 0, 1],
//        [1, 0, 1, 0, 1],
//        [1, 0, 1, 1, 0],
//        ]

//OUTPUT
// [1, 2, 2, 2, 5]
// The numbers could be ordered differently.

// The rivers can be clearly seen here:
// [
//   [1,  ,  , 1,  ],
//   [1,  , 1,  ,  ],
//   [ ,  , 1,  , 1],
//   [1,  , 1,  , 1],
//   [1,  , 1, 1,  ],
// ]

public class RiverSizes {

    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(visited[i][j])
                    continue;
                traverseNode(i, j, matrix, visited, result);
            }
        }
        return result;
    }

    public static void traverseNode(int i, int j, int[][] matrix, boolean[][] visited, List<Integer> result){
        int currentSize = 0;
        Stack<Integer[]> nodesToExplore = new Stack<>();
        nodesToExplore.push(new Integer[]{i, j});

        while(!nodesToExplore.isEmpty()){
            Integer[] currentNode = nodesToExplore.pop();
            i = currentNode[0];
            j = currentNode[1];
            if(visited[i][j])
                continue;
            visited[i][j] = true;
            if(matrix[i][j] == 0)
                continue;
            currentSize++;
            List<Integer[]> unvisitedNeighbors = getUnvisitedNeighbors(i, j, matrix, visited);
            nodesToExplore.addAll(unvisitedNeighbors);
        }
        if(currentSize > 0)
            result.add(currentSize);
    }

    public static List<Integer[]> getUnvisitedNeighbors(int i, int j, int[][] matrix, boolean[][] visited){
        List<Integer[]> unvisitedNeighbors = new ArrayList<>();
        if(i > 0 && !visited[i - 1][j])
            unvisitedNeighbors.add(new Integer[]{i - 1, j});
        if(i < matrix.length - 1 && !visited[i + 1][j])
            unvisitedNeighbors.add(new Integer[]{i + 1, j});
        if(j > 0 && !visited[i][j - 1])
            unvisitedNeighbors.add(new Integer[]{i, j - 1});
        if(j < matrix[0].length - 1 && !visited[i][j + 1])
            unvisitedNeighbors.add(new Integer[]{i, j + 1});
        return unvisitedNeighbors;
    }

    public static void main(String[] args) {
        int[][] input = {
            {1, 0, 0, 1, 0},
            {1, 0, 1, 0, 0},
            {0, 0, 1, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 1, 0},
        };
        List<Integer> result = riverSizes(input);
        for(int i: result)
            System.out.print(i + " ");
    }
}
