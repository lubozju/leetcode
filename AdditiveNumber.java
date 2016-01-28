/*
Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

For example:
"112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.

1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
"199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
1 + 99 = 100, 99 + 100 = 199
Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Follow up:
How would you handle overflow for very large input integers?
*/

public class Solution {
    public boolean isAdditiveNumber(String num) {
        // at least 3 numbers
        for (int i = 0; i < num.length() / 3; i++) {
            String headNum = num.substring(0, i + 1);
            List<String> path = new ArrayList<String>();
            if(isValid(headNum, path) && dfs(headNum, i + 1, path, num)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isValid(String number, List<String> path) {
        if (number.length() > 1 && number.charAt(0) == '0') {
            return false;
        }
        if (path.size() > 1) {
            String last = path.get(path.size() - 1);
            String last2 = path.get(path.size() - 2);
            if (!checkSum(last2, last, number)) {
                return false;
            } 
        }
        return true;
    }
    
    // check if num1 + num2 = sum
    private boolean checkSum(String num1, String num2, String sum) {
        int maxLength = Math.max(num1.length(), num2.length());
        if (sum.length() < maxLength || sum.length() > maxLength + 1) {
            return false;
        }
        // (i, j) <= k
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int k = sum.length() - 1;
        
        int r = 0;
        while (i >= 0 && j >= 0) {
            int d1 = Character.getNumericValue(num1.charAt(i));
            int d2 = Character.getNumericValue(num2.charAt(j));
            int s = Character.getNumericValue(sum.charAt(k));
            
            if ((d1 + d2 + r) % 10 != s) {
                return false;
            }
            r = (d1 + d2 + r) / 10;
            i--;
            j--;
            k--;
        }
        while (j >= 0) {
            int d2 = Character.getNumericValue(num2.charAt(j));
            int s = Character.getNumericValue(sum.charAt(k));
            if ((d2 + r) % 10 != s) {
                return false;
            }
            r = (d2 + r) / 10;
            j--;
            k--;
        }
        
        while (i >= 0) {
            int d1 = Character.getNumericValue(num1.charAt(i));
            int s = Character.getNumericValue(sum.charAt(k));
            if ((d1 + r) % 10 != s) {
                return false;
            }
            r = (d1 + r) / 10;
            i--;
            k--;
        }
        
        if (k == 0) {
            int s = Character.getNumericValue(sum.charAt(k));
            if (r != s) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(String curStr, int curIndex, List<String> path, String num) {
        if (curIndex == num.length() && path.size() > 1) {
            return true;
        }

        path.add(curStr);
        
        for (int i = curIndex; i < num.length(); i++) {
            String nextNum = num.substring(curIndex, i + 1);
            if (isValid(nextNum, path) && dfs(nextNum, i + 1, path, num)) {
                return true;
            }
        }
        path.remove(path.size() - 1);
        return false;
    }
}