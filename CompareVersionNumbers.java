/*
Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
*/

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        
        int leng1 = nums1.length;
        int leng2 = nums2.length;
        
        int i = 0;
        
        while (i < Math.min(leng1, leng2)) {
            int num1 = Integer.parseInt(nums1[i]);
            int num2 = Integer.parseInt(nums2[i]);
            if (num1 < num2) {
                return -1;
            }
            if (num1 > num2) {
                return 1;
            }
            i++;
        }
        
        while (i < leng1) {
            int num1 = Integer.parseInt(nums1[i]);
            if (num1 > 0) {
                return 1;
            }
            i++;
        }

        while (i < leng2) {
            int num2 = Integer.parseInt(nums2[i]);
            if (num2 > 0) {
                return -1;
            }
            i++;
        }
        return 0;
    }
}

public class Solution {
    // Time O(n)
    // Space O(n)
    public int compareVersion(String version1, String version2) {
        String[] array1 = version1.split("\\.");
        String[] array2 = version2.split("\\.");
        
        int i = 0;
        while (i < array1.length && i < array2.length) {
            int temp = compare(array1[i], array2[i]);
            if (temp != 0) {
                return temp;
            }
            i++;
        }
        while (i < array1.length) {
            if (processing(array1[i]).length() != 0) {
                return 1;
            }
            i++;
        }
        while (i < array2.length) {
            if (processing(array2[i]).length() != 0) {
                return -1;
            }
            i++;
        }
        
        return 0;
    }
    
    private int compare(String word1, String word2) {
        word1 = processing(word1);
        word2 = processing(word2);
        if (word1.length() == word2.length()) {
            if (word1.compareTo(word2) == 0) {
                return 0;
            }
            if (word1.compareTo(word2) > 0) {
                return 1;
            }
            return -1;
        }
        if (word1.length() > word2.length()) {
            return 1;
        }
        return -1;
    }
    
    private String processing(String word) {
        int i = 0;
        while (i < word.length()) {
            if (word.charAt(i) == '0') {
                i++;
            } else {
                break;
            }
        }
        return word.substring(i);
    }
    
}