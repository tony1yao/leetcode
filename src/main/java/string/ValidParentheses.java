package string;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c: chars) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char openC = stack.pop();
                    if (!match(openC, c)) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean match(char open, char close) {
        if (open == '{') {
            return close == '}';
        } else if (open == '[') {
            return close == ']';
        } else if (open == '(') {
            return close == ')';
        }
        return false;
    }
}
