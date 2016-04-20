/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

public class Solution {
    public boolean isPalindrome(String s) {
        char[] sArray = s.toLowerCase().toCharArray();
        
        int i = 0;
        int j = sArray.length - 1;
        
        while (i < j) {
            if (Character.isLetterOrDigit(sArray[i]) && Character.isLetterOrDigit(sArray[j])) {
                if (sArray[i] != sArray[j]) {
                    return false;
                }
                i++;
                j--;
            } else {
                if (!Character.isLetterOrDigit(sArray[i])) {
                    i++;
                }
                if (!Character.isLetterOrDigit(sArray[j])) {
                    j--;
                }
            }
        }
        
        return true;
    }
}