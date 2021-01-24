package info.sandroalmeida.string;

public class CaesarCypherEncryptor {

    /*
    * a = 97 and z = 122 ASCII table
    * */
    public static String caesarCypherEncryptor(String str, int key) {

        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        if(key > 26){
            key = key % 26;
        }
        for(char c: chars){
            int newValue = c;
            if(newValue + key > 122){
                newValue = newValue + key - 122 + 97 - 1;
            } else{
                newValue += key;
            }
            sb.append((char) newValue);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(caesarCypherEncryptor("abc", 52));
    }

}
