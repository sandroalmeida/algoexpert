package info.sandroalmeida.string;

public class LongestPalindromicSubstring {

    public static String longestPalindromicSubstring(String str) {

        String longest = "";

        for(int i = 0; i < str.length(); i++){
            for(int j = i; j < str.length(); j++){
                String substring = str.substring(i, j+1);
                if(checkPalindromic(substring) && substring.length() > longest.length()){
                    longest = substring;
                }
            }
        }
        return longest;
    }

    public static boolean checkPalindromic(String substring){
        int i = 0, j = substring.length() - 1;
        while(i < j){
            if(substring.charAt(i) != substring.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromicSubstring("abaxyzzyxf"));
    }
}
