package stack;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (topChar == '(' && c != ')') {
                    return false;
                }
                if (topChar == '{' && c != '}') {
                    return false;
                }
                if (topChar == '[' && c != ']') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}