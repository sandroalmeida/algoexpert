package info.sandroalmeida.dinamicProgramming;

public class DecodeWays_Recursive {

    public static int numDecodings(String s) {
        return helper(s);
    }

    public static int helper(String str){
        if(str == null || str.length() == 0) return 0;
        if(str.length() == 1) return 1;

        String subsOne = str.substring(1);
        String subsTwo = str.substring(2);

        int totalOne = helper(subsOne);
        int totalTwo = 0;
        int firstTwo = Integer.parseInt(str.substring(0, 2));
        if(firstTwo >= 10 && firstTwo <= 26)
            totalTwo = helper(subsTwo);
        return totalOne + totalTwo;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("1233"));
    }

}
