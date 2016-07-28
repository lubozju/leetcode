/*
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
Hint:

Did you see a pattern in dividing the number into chunk of words? For example, 123 and 123000.
Group the number by thousands (3 digits). You can write a helper function that takes a number less than 1000 and convert just that chunk to words.
There are many edge cases. What are some good test cases? Does your code work with input such as 0? Or 1000010? (middle chunk is zero and should not be printed out)

*/

public class Solution {
    // Time O(number of digits)
    // Space O(1)
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<String>();
        
        while (num > 0) {
            int temp = num % 1000;
            stack.push(help(temp));
            num = num / 1000;
        }
        String[] unit = {"Thousand", "Million", "Billion"};
        int size = stack.size();
        int index = size - 2;
        while (!stack.isEmpty()) {
            String word = stack.pop();
            if (word.length() > 0) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(word);
                if (index >= 0) {
                    sb.append(" ");
                    sb.append(unit[index]);
                }
            }
            index--;
        }
        return sb.toString();
    }
    
    private String help(int num) {
        String[] nums = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        StringBuilder sb = new StringBuilder();
        int hundred = num / 100;
        if (hundred > 0) {
            sb.append(nums[hundred]);
            sb.append(" ");
            sb.append("Hundred");
        }
        int ten = num % 100;
        if (ten < 20 && ten > 0) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(nums[ten]);
        } else {
            if (ten > 0) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(tens[ten / 10 - 2]);
                if (ten % 10 != 0) {
                    if (sb.length() > 0) {
                        sb.append(" ");
                    }
                    sb.append(nums[ten % 10]);
                }
            }
        }
        return sb.toString();
    }
}