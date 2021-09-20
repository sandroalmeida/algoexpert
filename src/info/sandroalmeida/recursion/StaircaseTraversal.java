package info.sandroalmeida.recursion;

public class StaircaseTraversal {

    static int count = 0;

    public static int staircaseTraversal(int height, int maxSteps) {
        helper(height, maxSteps, 0);
        return count;
    }

    public static void helper(int height, int maxSteps, int index){
        for(int i = 1; i <= maxSteps; i++){
            int restPath = height - index;
            int diff = restPath - i;
            if(diff > 0)
                helper(height, maxSteps, index + i);
            else if(diff < 0)
                break;
            else
                count++;
        }
    }

    public static void main(String[] args) {
        System.out.println(staircaseTraversal(10, 1));
    }
}
