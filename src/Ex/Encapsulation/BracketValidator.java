package Ex.Encapsulation;

import java.util.Stack;

public class BracketValidator {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String expression1 = "({[(){}]})";
        String expression2 = "({[([)]]})";

        System.out.println(expression1 + " is valid: " + isValid(expression1));
        System.out.println(expression2 + " is valid: " + isValid(expression2));
    }
}