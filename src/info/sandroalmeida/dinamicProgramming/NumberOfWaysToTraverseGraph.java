package info.sandroalmeida.dinamicProgramming;

public class NumberOfWaysToTraverseGraph {

    public static int numberOfWaysToTraverseGraph(int width, int height) {
        // create matrix of results
        int[][] results = new int[height][width];

        // filling up row 0 with 1
        for(int i = 0; i < width; i++)
            results[0][i] = 1;

        // filling up column 0 with 1
        for(int i = 0; i < height; i++)
            results[i][0] = 1;

        // calculating rest of numbers adding up and left
        for(int row = 1; row < height; row++){
            for(int column = 1; column < width; column++){
                results[row][column] = results[row][column - 1] + results[row - 1][column];
            }
        }

        // final result will be the last cell
        return results[height - 1][width - 1];
    }

    public static void main(String[] args) {
        System.out.println(numberOfWaysToTraverseGraph(4, 3));
    }
}
