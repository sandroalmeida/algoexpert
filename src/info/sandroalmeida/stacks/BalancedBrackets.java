package info.sandroalmeida.stacks;

import java.util.Stack;

public class BalancedBrackets {

    public static boolean balancedBrackets(String str) {

        Stack<Character> brackets = new Stack<>();

        for(char c: str.toCharArray()){
            if(c == '(' || c == '[' || c == '{') {
                brackets.push(c);
            } else if(c == ')' || c == ']' || c == '}') {
              if(brackets.empty())
                  return false;

              char lastInsert = brackets.peek();
              if(c == ')' && lastInsert != '(')
                  return false;
              else if(c == ']' && lastInsert != '[')
                  return false;
              else if(c == '}' && lastInsert != '{')
                  return false;

              brackets.pop();
            }
        }
        return brackets.empty();
    }

    public static void main(String[] args) {
        String input = "([])(){}(())()()";
        System.out.println(balancedBrackets(input));
    }

}
