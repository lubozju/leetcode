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
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int tag = 1;
        while (num > 0) {
            int res = num % 1000;
            StringBuilder temp = help(res);
            if (temp.length() > 0) {
                if (tag == 2){
                    temp.append(" Thousand");
                } else if (tag == 3) {
                    temp.append(" Million");
                } else if (tag == 4){
                    temp.append(" Billion");
                }
                stack.push(temp.toString());
            }
            tag++;
            num /= 1000;
        }
        
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            sb.append(" ");
        }
        
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    private StringBuilder help(int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) {
            return sb;
        }        
        String[] nums = new String[10];
        nums[1] = "One";
        nums[2] = "Two";
        nums[3] = "Three";
        nums[4] = "Four";
        nums[5] = "Five";
        nums[6] = "Six";
        nums[7] = "Seven";
        nums[8] = "Eight";
        nums[9] = "Nine";
        
        String[] nums2 = new String[10];
        nums2[0] = "Ten";
        nums2[1] = "Eleven";
        nums2[2] = "Twelve";
        nums2[3] = "Thirteen";
        nums2[4] = "Fourteen";
        nums2[5] = "Fifteen";
        nums2[6] = "Sixteen";
        nums2[7] = "Seventeen";
        nums2[8] = "Eighteen";
        nums2[9] = "Nineteen";
        
        String[] nums3 = new String[10];
        nums3[2] = "Twenty";
        nums3[3] = "Thirty";
        nums3[4] = "Forty";
        nums3[5] = "Fifty";
        nums3[6] = "Sixty";
        nums3[7] = "Seventy";
        nums3[8] = "Eighty";
        nums3[9] = "Ninety";
        
        int h = num / 100;
        if (h > 0) {
            sb.append(nums[h] + " Hundred");
        }
        int t = num % 100 / 10;
        if (t == 1) {
            int s = num % 10;
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(nums2[s]);
        } else if (t > 1){
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(nums3[t]);
            int s = num % 10;
            if (s > 0) {
                sb.append(" " + nums[s]);
            }
        } else {
            int s = num % 10;
            if (s > 0) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(nums[s]);
            }
        }
        return sb;
    }
}


public class Solution {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        
        int level = 0;
        String[] units = {"", "Thousand", "Million", "Billion"};
        String[] partialResults = new String[4];
        String[] zeroNineteen = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };
        String[] twNinty = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        while (num > 0) {
            int lastThree = num % 1000;
            num = num / 1000;
            partialResults[level++] = help(lastThree, zeroNineteen, twNinty);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 3; i >= 0; i--) {
            if (partialResults[i] == null) {
                continue;
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(partialResults[i]);
            if (i > 0) {
                sb.append(" ");
                sb.append(units[i]);
            }
        }
        return sb.toString();
    }
    
    private String help(int num, String[] zeroNineteen, String[] twNinty) {
        if (num == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int h = num / 100;
        if (h > 0) {
            sb.append(zeroNineteen[h]);
            sb.append(" ");
            sb.append("Hundred"); 
        }
        int lastTwo = num % 100;
        if (lastTwo == 0) {
            return sb.toString();
        }
        if (lastTwo < 20) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(zeroNineteen[lastTwo]);
        } else {
            int t = lastTwo / 10;
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(twNinty[t]);
            int d = lastTwo % 10;
            if (d != 0) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }   
                sb.append(zeroNineteen[d]);
            }
        }
        return sb.toString();
    }
}
