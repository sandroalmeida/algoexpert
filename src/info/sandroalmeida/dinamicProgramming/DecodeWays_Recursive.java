package info.sandroalmeida.dinamicProgramming;

public class DecodeWays_Recursive {

    public static int numDecodings(String s) {
        return helper(s, s.length());
    }

    public static int helper(String str, int size){
        if(size == 0)
            return 1;
        int p = str.length() - size;

        if(str.indexOf(p) == '0')
            return 0;

        int result = helper(str, size - 1);

        if(size >= 2 && Integer.parseInt(str.substring(p, p + 2)) <= 26)
            result += helper(str, size - 2);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("216"));
    }

}
