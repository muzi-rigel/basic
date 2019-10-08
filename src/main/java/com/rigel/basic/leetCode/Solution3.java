package com.rigel.basic.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3 {

    public static int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                Integer integer = map.get(c);
                i = Math.max(integer, i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(c, j + 1);
        }
        return ans;
    }


    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        System.out.println("字符串为" + s);
        while (i < n && j < n) {
            // try to extend the range [i, j]
            char curr = s.charAt(j);
            boolean flag = true;
            Character c;
            int a = i,b = j;
            if (!set.contains(s.charAt(j))) {
                c = s.charAt(j++);
                set.add(c);
                ans = Math.max(ans, j - i);
            } else {
                c = s.charAt(i++);
                set.remove(c);
                flag = false;
            }
            System.out.printf("i=%d j=%d curr=%s %s %s ans=%s \tset=%s \n", a, b, curr, flag ? "add" : "rem", c, ans, set);
        }
        return ans;
    }


    //超出时间限制 TLE
    public static int lengthOfLongestSubstring1(String s) {
        int maxLength = s.length() == 1 ? 1 : 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String subString = s.substring(i, j + 1);
                System.out.println("i" + i + "j" + j + "sub---" + subString);
                if (checkDup(subString)) {
                    maxLength = Math.max(maxLength, j - i);
//                    System.out.println("ok---" + subString);
                }
//                System.out.println("i="+i+" j="+j);
            }
        }
        return maxLength;
    }


    //1  字符串是否重复
    public static boolean checkDup(String str) {
        Set<Character> set = new HashSet<Character>();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (set.contains(aChar)) return false;
            set.add(aChar);
        }
        return true;
    }

    //2

    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring1("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring1("a"));
//        System.out.println(lengthOfLongestSubstring1(""));
//        System.out.println(lengthOfLongestSubstring1("bbbbbbbbbb"));
//        System.out.println(lengthOfLongestSubstring1("pwwkew"));
//        System.out.println(lengthOfLongestSubstring1("au"));

//        System.out.println(lengthOfLongestSubstring3("pwwkew"));
        System.out.println(lengthOfLongestSubstring2("abcdcefg"));
    }
}
