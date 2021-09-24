package info.sandroalmeida.dinamicProgramming;

public class LevenshteinDistance {

    public static int levenshteinDistance(String str1, String str2) {

        // db matrix with all partial solutions
        int[][] solutions = new int[str2.length() + 1][str1.length() + 1];

        // filing up the first row and first col -> 0,1,2,3 ... n
        for(int i = 0; i < str2.length() + 1; i++){
            for(int j = 0; j < str1.length() + 1; j++){
                solutions[i][j] = j;
            }
            solutions[i][0] = i;
        }

        // filling up the rest of the matrix
        for(int i = 1; i < str2.length() + 1; i++) {
            for (int j = 1; j < str1.length() + 1; j++) {
                if(str2.charAt(i - 1) == str1.charAt(j - 1))
                    solutions[i][j] = solutions[i - 1][j - 1];
                else
                    solutions[i][j] = 1 + Math.min(solutions[i - 1][j - 1], Math.min(solutions[i - 1][j], solutions[i][j - 1]));
            }
        }

        // last cell will be the min solution
        return solutions[str2.length()][str1.length()];
    }

    public static void main(String[] args) {
        System.out.println(levenshteinDistance("biting", "mitten"));
    }
}
