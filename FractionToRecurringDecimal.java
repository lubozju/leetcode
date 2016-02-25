/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
*/

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long nLong = numerator;
        long dLong = denominator;
        boolean neg = false;
        if (numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0) {
            neg = true;
        }
        if (nLong < 0) {
            nLong = -nLong;
        }
        if (dLong < 0) {
            dLong = -dLong;
        }
        
        StringBuilder sb = new StringBuilder();
        
        long p = nLong / dLong;
        long q = nLong % dLong;
        if (neg) {
            sb.append('-');
        }
        sb.append(p);
        if (q == 0) {
            return sb.toString();
        }

        sb.append(".");
        
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(q, sb.length());

        while (q != 0) {
            nLong = q * 10;
            p = nLong / dLong;
            q = nLong % dLong;
            sb.append(p);
            Integer index = map.put(q, sb.length());
            if (index != null) {
                sb.insert((int)index, '(');
                sb.append(')');
                return sb.toString();
            }
        }

        return sb.toString();
    }
}