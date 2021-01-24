package info.sandroalmeida.array;

public class RunLengthEncoding {

    public static String runLengthEncoding(String string) {

        char[] chars = string.toCharArray();
        char current = chars[0];
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(char c: chars){
            if(c == current && count < 9) {
                count++;
            } else{
                if(count > 0)
                    sb.append(count);
                sb.append(current);
                current = c;
                count = 1;
            }
        }
        if(count > 0)
            sb.append(count);
        sb.append(current);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(runLengthEncoding("AAAAAAAAAAAAABBCCCCDD"));
    }
}
