/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/

public class Solution {
	//Time O(1)
	//Space O(1)
    public String intToRoman(int num) {
        int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < numbers.length) {
            while (num >= numbers[i]) {
                sb.append(romans[i]);
                num -= numbers[i];
            }
            i++;
        }
        return sb.toString();
    }
}

public class Solution {
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX","V", "IV", "I"};
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            if (num / nums[i] > 0) {
                int k = num / nums[i];
                for (int j = 0; j < k; j++) {
                    sb.append(romans[i]);
                }
                num = num % nums[i];
            }
            i++;
        }
        return sb.toString();
    }
}