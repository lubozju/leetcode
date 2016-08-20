/*
Given a nested list of integers represented as a string, implement a parser to deserialize it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Note: You may assume that the string is well-formed:

String is non-empty.
String does not contain white spaces.
String contains only digits 0-9, [, - ,, ].
Example 1:

Given s = "324",

You should return a NestedInteger object which contains a single integer 324.
Example 2:

Given s = "[123,[456,[789]]]",

Return a NestedInteger object containing a nested list with 2 elements:

1. An integer containing value 123.
2. A nested list containing two elements:
    i.  An integer containing value 456.
    ii. A nested list with one element:
         a. An integer containing value 789.
*/

public class Solution {
    // Time O(n)
    // Space O(n)
    public NestedInteger deserialize(String s) {
        if (s.matches("-?\\d+")) {
            return new NestedInteger(Integer.parseInt(s));
        }
        NestedInteger curNi = null;
        Stack<NestedInteger> stack = new Stack<>();
        int num = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                if (curNi != null) {
                    stack.push(curNi);
                }
                curNi = new NestedInteger();
            } else if (c == '-') {
                sign = -1;
            } else if (c == ']') {
                // check if prev char is digit
                if (Character.isDigit(s.charAt(i - 1))) {
                    curNi.add(new NestedInteger(num));
                }
                // check if stack is empty
                if (!stack.empty()) {
                    NestedInteger parentNi = stack.pop();
                    parentNi.add(curNi);
                    curNi = parentNi;
                }
            } else if (c == ',') {
                // check if prev char is digit
                if (Character.isDigit(s.charAt(i - 1))) {
                    curNi.add(new NestedInteger(num));
                }
                num = 0;
                sign = 1;
            } else {
                num = num * 10 + sign * (c - '0');
            }
        }
        
        return curNi;
    }
}