/*
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.

click to show corner cases.

Corner Cases:
A line other than the last line might contain only one word. What should you do in this case?
In this case, that line should be left-justified.
*/

public class Solution {
    // Time O(n)
    // Space O(n)
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        int count = 0;
        int i = 0;
        int start = 0;
        while (i < words.length) {
            String word = words[i];
            int tempCount;
            if (count == 0) {
                tempCount = word.length();
            } else {
                tempCount = count + word.length() + 1;// 1 is the space
            }
            if (tempCount > maxWidth) {
                String line = generateLine(count, start, i - 1, maxWidth, words);
                result.add(line);
                start = i;
                count = 0;
                // i is not increased
            } else {
                count = tempCount;
                i++;
            }
        }
        String line = generateLine(count, start, words.length - 1, maxWidth, words);
        result.add(line);
        return result;
    }
    
    private String generateLine(int count, int start, int end, int maxWidth, String[] words) {
        StringBuilder sb = new StringBuilder();
        // last line or line with only one word
        if (end == words.length - 1 || start == end) {
            int i = start;
            while (maxWidth > 0) {
                if (i <= end) {
                    if (i == start) {
                        sb.append(words[i]);
                        maxWidth = maxWidth - words[i].length();
                    } else {
                        sb.append(" ");
                        sb.append(words[i]);
                        maxWidth = maxWidth - words[i].length() - 1;
                    }
                    i++;
                } else {
                    sb.append(" ");
                    maxWidth = maxWidth - 1;
                }
            }
        } else {
            int num = end - start;
            double totalSpace = maxWidth - count;    
            for (int i = start; i <= end; i++) {
                if (i == start) {
                    sb.append(words[i]);
                } else {
                    sb.append(" ");
                    // the number of extra space is (int)Math.ceil((totalSpace) / num);
                    int numExtraSpace = (int)Math.ceil((totalSpace) / num);
                    totalSpace = totalSpace - numExtraSpace;
                    while (numExtraSpace > 0) {
                        sb.append(" ");
                        numExtraSpace--;
                    }
                    sb.append(words[i]);
                    num--;
                }
            }
        }
        
        return sb.toString();
    }
}