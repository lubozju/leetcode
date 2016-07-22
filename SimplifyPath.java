/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
*/

public class Solution {
    // Time O(n)
    // Space O(n)
    public String simplifyPath(String path) {
        StringBuilder result = new StringBuilder();
        Deque<String> stack = new LinkedList<String>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c != '/') {
                word.append(c);
            } else {
                if (word.toString().equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (!word.toString().equals(".") && word.length() > 0){
                    stack.push(word.toString());
                }
                word = new StringBuilder();
            }
        }
        if (word.toString().equals("..")) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        } else if (!word.toString().equals(".") && word.length() > 0){
            stack.push(word.toString());
        }
        result.append("/");
        while (!stack.isEmpty()) {
            result.append(stack.removeLast());
            result.append("/");
        }
        if (result.length() > 1) {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }
}