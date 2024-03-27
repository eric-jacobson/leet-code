package jacobson.leet.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(longestCommonPrefix(new String[]{"flower", "flower", "flower", "flow"}));
    }

    private static boolean isPalindrome(int x) {
        String num = String.valueOf(x);
        int n = num.length();
        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) != num.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static int romanToInt(String s) {
        Map<Character, Integer> romanValues = new HashMap<>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int decimalValue = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && romanValues.get(s.charAt(i)) < romanValues.get(s.charAt(i + 1))) {
                decimalValue -= romanValues.get(s.charAt(i));
            } else {
                decimalValue += romanValues.get(s.charAt(i));

            }
        }
        return decimalValue;
    }

    private static String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);
        StringBuilder result = new StringBuilder();
        String first = strs[0];
        String last = strs[strs.length - 1];
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return result.toString();
            }
            result.append(first.charAt(i));
        }
        return result.toString();

        // first attempt
//        if (strs.length == 1) {
//            return strs[0];
//        }
//        String result = "";
//        String first = strs[0];
//        for (int i=0; i<first.length(); i++) {
//            char current = first.charAt(i);
//            for (String str : strs) {
//                if (!str.startsWith(result + String.valueOf(current))) {
//                    return result;
//                }
//            }
//            result += String.valueOf(current);
//        }
//        return result;
    }
}