/*
You are playing the following Bulls and Cows game with your friend: You write a 4-digit secret number and ask your friend to guess it. Each time your friend guesses a number, you give a hint. The hint tells your friend how many digits are in the correct positions (called "bulls") and how many digits are in the wrong positions (called "cows"). Your friend will use those hints to find out the secret number.

For example:

Secret number:  "1807"
Friend's guess: "7810"
Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".

Please note that both secret number and friend's guess may contain duplicate digits, for example:

Secret number:  "1123"
Friend's guess: "0111"
In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
*/

public class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        char[] sArray = secret.toCharArray();
        char[] gArray = guess.toCharArray();
        int bullCount = 0;
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] == gArray[i]) {
                bullCount++;
            } else {
                Integer value = map.get(sArray[i]);
                if (value == null) {
                    value = 1;
                } else {
                    value++;
                }
                map.put(sArray[i], value);
            }
        }
        
        int cowCount = 0;
        for (int i = 0; i < gArray.length; i++) {
            if (sArray[i] == gArray[i]) {
                continue;
            }
            Integer value = map.get(gArray[i]);
                if (value != null && value > 0) {
                    value--;
                    map.put(gArray[i], value);
                    cowCount++;
                }
        }
        return bullCount + "A" + cowCount + "B";
    }
}