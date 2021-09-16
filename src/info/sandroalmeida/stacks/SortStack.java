package info.sandroalmeida.stacks;

import java.util.ArrayList;
import java.util.Arrays;

public class SortStack {

    public static ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        if(stack.size() > 1){
            boolean orderChanged = true;
            while(orderChanged){
                orderChanged = recursiveSort(stack);
            }
        }
        return stack;
    }

    public static boolean recursiveSort(ArrayList<Integer> stack){
        boolean orderChanged = false;
        // pop last element
        int lastElement = stack.remove(stack.size() - 1);
        // need to call the recursive method again
        if(stack.size() > 1)
            orderChanged = recursiveSort(stack);
        // compare
        if(stack.get(stack.size() - 1) > lastElement){
            int previousElement = stack.remove(stack.size() - 1);
            stack.add(lastElement);
            stack.add(previousElement);
            orderChanged = true;
        } else{
            stack.add(lastElement);
        }
        return orderChanged;
    }

    public static void main(String[] args) {
        ArrayList<Integer> stack = new ArrayList<>(Arrays.asList(-5, 2, -2, 4, 3, 1));
        sortStack(stack);
    }
}
