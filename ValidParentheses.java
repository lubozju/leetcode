/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            Character peek = stack.peek();
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (peek == null) {
                    return false;
                }
                if (c == ')' && peek == '(' || c == '}' && peek == '{' || c == ']' && peek == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}