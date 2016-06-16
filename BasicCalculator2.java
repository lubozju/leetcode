/*
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
Note: Do not use the eval built-in library function.
*/

public class Solution {
    public int calculate(String s) {
        int result = 0;
        int plus = 1;
        int multiply = 1;
        int num = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                if (!stack.isEmpty()) {
                    result = (int) (result * Math.pow((double)num, multiply));
                    int sign = stack.pop();
                    int resultTemp = stack.pop();
                    result = resultTemp + sign * result;
                } else {
                    result += plus * num; 
                }
                if (c == '+') {
                    plus = 1;
                } else {
                    plus = -1;
                }
                num = 0;
            } else if (c == '*' || c == '/') {
                if (stack.isEmpty()) {
                    stack.push(result);
                    stack.push(plus);
                    result = num;
                } else {
                    result = (int) (result * Math.pow((double)num, multiply));
                }
                if (c == '*') {
                    multiply = 1;
                } else {
                    multiply = -1;
                }
                num = 0;
            } else if (Character.isDigit(c)) {
                num = 10 * num + (c - '0');
            }
        }
        // * or /
        if (!stack.isEmpty()) {
            result = (int) (result * Math.pow((double)num, multiply));
            int sign = stack.pop();
            int resultTemp = stack.pop();
            result = resultTemp + sign * result;
        } else {
            result += plus * num; 
        }
        return result;
    }
}

public class Solution {
    // Time: O(n)
    // Space : O(1)
    public int calculate(String s) {
        int result = 0;
        int sign = 1;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                if (sign == 1) {
                    result = result + num;
                } else if (sign == 2) {
                    result = result - num;
                } else if (sign == 3) {
                    result = result * num;
                } else {
                    result = result / num;
                }
                if (!stack.isEmpty()) {
                    num = stack.pop();
                    sign = stack.pop();
                    if (sign == 1) {
                        result = result + num;
                    } else {
                        result = num - result;
                    }
                }
                if (c == '+') {
                    sign = 1;
                } else {
                    sign = 2;
                }
                num = 0;
            } else if (c == '*' || c == '/') {
                if (sign == 3) {
                    result = result * num;
                } else if (sign == 4) {
                    result = result / num;
                } else {
                    stack.push(sign);
                    stack.push(result);
                    result = num;
                }
                if (c == '*') {
                    sign = 3;
                } else {
                    sign = 4;
                }
                num = 0;
            }
        }
        
        // for the last number
        if (sign == 1) {
            result = result + num;
        } else if (sign == 2) {
            result = result - num;
        } else if (sign == 3) {
            result = result * num;
        } else {
            result = result / num;
        }
        
        if (!stack.isEmpty()) {
            num = stack.pop();
            sign = stack.pop();
            if (sign == 1) {
                result = result + num;
            } else {
                result = num - result;
            }
        }
        
        return result;
    }
}