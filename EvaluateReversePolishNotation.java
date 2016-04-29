/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

public class Solution {
    public int evalRPN(String[] tokens) {
        int result = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        for (String token : tokens) {
            if (token.equals("+")) {
                result = stack.pop() + stack.pop();
                stack.push(result);
            } else if (token.equals("-")) {
                int value1 = stack.pop();
                int value2 = stack.pop();
                result = value2 - value1;
                stack.push(result);
            } else if (token.equals("*")) {
                result = stack.pop() * stack.pop();
                stack.push(result);
            } else if (token.equals("/")) {
                int value1 = stack.pop();
                int value2 = stack.pop();
                result = value2 / value1;
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}