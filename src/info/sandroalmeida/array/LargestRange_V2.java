package info.sandroalmeida.array;

import java.util.HashMap;
import java.util.Map;

public class LargestRange_V2 {

    public static int[] largestRange(int[] array) {

        int[] bestRange = new int[2];
        int longestLength = 0;
        Map<Integer, Boolean> nums = new HashMap<>();
        for(int num: array) {
            nums.put(num, true);
        }
        for(int num: array) {
            if(!nums.get(num)) {
                continue;
            }
            nums.put(num, false);
            int currentLength = 1;
            int left = num - 1;
            int right = num + 1;
            while (nums.containsKey(left)) {
                nums.put(left, false);
                currentLength++;
                left--;
            }
            while (nums.containsKey(right)) {
                nums.put(right, false);
                currentLength++;
                right++;
            }
            if(currentLength > longestLength) {
                longestLength = currentLength;
                bestRange = new int[] {left + 1, right - 1};
            }
        }
        return bestRange;
    }

    public static void main(String[] args) {
        int[] result = largestRange(new int[]{19, -1, 18, 17, 2, 10, 3, 12, 5, 16, 4, 11, 8, 7, 6, 15, 12, 12, 2, 1, 6, 13, 14});
        System.out.println(result[0] + "," + result[1]);
    }
}
