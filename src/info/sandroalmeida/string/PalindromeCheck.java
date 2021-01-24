package info.sandroalmeida.string;

public class PalindromeCheck {

    public static boolean isPalindrome(String str) {
        char[] chars = str.toCharArray();
        int p1 = 0, p2 = chars.length - 1;
        boolean check = true;

        while(p1 < p2){
            if(chars[p1] != chars[p2])
                check = false;
            p1++;
            p2--;
        }

        return check;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("abcdcba"));
    }
}
