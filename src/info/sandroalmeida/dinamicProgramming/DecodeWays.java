package info.sandroalmeida.dinamicProgramming;

public class DecodeWays {

    public static int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[s.length()] = 1;

        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '0') {
                dp[i] = 0;
            }else {
                dp[i] += dp[i + 1];
                if(i + 2 <= s.length() && Integer.parseInt(s.substring(i, i + 2)) <= 26)
                    dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("1233"));
    }

}
