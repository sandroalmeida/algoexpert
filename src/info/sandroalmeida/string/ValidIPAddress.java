package info.sandroalmeida.string;

import java.util.ArrayList;

public class ValidIPAddress {

    public static ArrayList<String> validIPAddresses(String string) {

        ArrayList<String> result = new ArrayList<>();
        int p1 = 1;
        while(p1 <= string.length() - 2){
            String section1 = string.substring(0,p1);
            int p2 = p1+1;
            while(p2 <= string.length() - 1){
                String section2 = string.substring(p1, p2);
                int p3 = p2+1;
                while(p3 < string.length()){
                    String section3 = string.substring(p2,p3);
                    String section4 = string.substring(p3);
                    p3++;
                    if(isValid(section1) && isValid(section2) && isValid(section3) && isValid(section4))
                        result.add(section1 + "." + section2 + "." + section3 + "." + section4);
                }
                p2++;
            }
            p1++;
        }

        return result;
    }

    public static boolean isValid(String section){
        if(section.equals("")) return false;
        if(section.length() > 1 && section.charAt(0) == '0') return false;
        if(Integer.parseInt(section) > 255) return false;
        return true;
    }

    public static void main(String[] args) {
        ArrayList<String> result = validIPAddresses("1921680");
        for(String item: result)
            System.out.println(item);
    }
}
