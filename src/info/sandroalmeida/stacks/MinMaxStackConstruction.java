package info.sandroalmeida.stacks;

import java.util.List;

public class MinMaxStackConstruction {

    static class MinMaxStack {
        public List<Integer> stack;
        public List<int[]> minMaxStack;

        public MinMaxStack(List<Integer> stack, List<int[]> minMaxStack) {
            this.stack = stack;
            this.minMaxStack = minMaxStack;
        }

        public int peek() {
            return stack.get(stack.size() - 1);
        }

        public int pop() {
            minMaxStack.remove(minMaxStack.size() - 1);
            return stack.remove(stack.size() - 1);
        }

        public void push(Integer number) {
            int[] newMinMax = new int[]{number, number};
            if(!minMaxStack.isEmpty()){
                int[] lastMinMax = minMaxStack.get(minMaxStack.size() - 1);
                newMinMax[0] = Math.min(lastMinMax[0], newMinMax[0]);
                newMinMax[1] = Math.max(lastMinMax[1], newMinMax[1]);
            }
            minMaxStack.add(newMinMax);
            stack.add(number);
        }

        public int getMin() {
            return minMaxStack.get(minMaxStack.size() - 1)[0];
        }

        public int getMax() {
            return minMaxStack.get(minMaxStack.size() - 1)[1];
        }
    }

}
