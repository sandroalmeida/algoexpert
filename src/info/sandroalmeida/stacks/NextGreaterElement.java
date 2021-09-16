package info.sandroalmeida.stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] array) {

        int[] result = new int[array.length];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for(int idx = 0; idx < 2 * array.length; idx++){
            int circularIdx = idx % array.length;

            while(stack.size() > 0 && array[stack.peek()] < array[circularIdx]) {
                int top = stack.pop();
                result[top] = array[circularIdx];
            }
            stack.push(circularIdx);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[] {2, 5, -3, -4, 6, 7, 2};
        int[] output = nextGreaterElement(input);
    }

}
