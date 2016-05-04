/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".
*/

public class Solution {
    public String reverseVowels(String s) {
        char[] sArray = s.toCharArray();
        int i = 0;
        int j = sArray.length - 1;
        Set<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        
        while (i < j) {
            if (!set.contains(sArray[i])) {
                i++;
            }
            if (!set.contains(sArray[j])) {
                j--;
            }
            if (set.contains(sArray[i]) && set.contains(sArray[j])) {
                char temp = sArray[i];
                sArray[i] = sArray[j];
                sArray[j] = temp;
                i++;
                j--;
            }
        }
        return new String(sArray);
    }
}