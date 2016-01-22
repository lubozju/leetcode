/*
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
Note: Do not use the eval built-in library function.
*/

public class Solution {
    public int calculate(String s) {
        int sign = 1;
        int number = 0;
        int result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                number = 0;
                result = 0;
            } else if (c == ')') {
                result += number * sign;
                result *= stack.pop();
                result += stack.pop();
                number = 0;
            } else if (c == '+') {
                result += number * sign;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += number * sign;
                number = 0;
                sign = -1;
            } else if (Character.isDigit(c)) {
                number = 10 * number + Character.digit(c, 10);
            }
        }
        
        if (number != 0) {
            result += number * sign;
        }
        
        return result;
    }
}