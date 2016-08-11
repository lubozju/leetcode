/*
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
*/

public class Solution {
	// Time O(n)
	// Space O(1)
    public boolean isNumber(String s) {
        boolean hasDot = false;
        boolean hasNumber = false;
        boolean hasE = false;
        
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (c == 'e') {
                // e has to appear after number and only once
                if (!hasNumber || hasE) {
                    return false;
                }
                hasE = true;
                // once e appears, hasNumber and hasDot clears
                hasNumber = false;
                hasDot = false;
            } else if (c == '.') {
                // dot can only appear once and before e
                if (hasDot || hasE) {
                    return false;
                }
                hasDot = true;
            } else if (c == '+' || c == '-') {
                // '+' or '-' only valid if no number and no dot(or after e)
                if (hasNumber || hasDot) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return hasNumber;
    }
}