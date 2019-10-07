package com.rigel.basic.leetCode;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {

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
        System.out.println(lengthOfLongestSubstring1("abcabcbb"));
        System.out.println(lengthOfLongestSubstring1("a"));
        System.out.println(lengthOfLongestSubstring1(""));
//        System.out.println(lengthOfLongestSubstring1("bbbbbbbbbb"));
//        System.out.println(lengthOfLongestSubstring1("pwwkew"));
//        System.out.println(lengthOfLongestSubstring1("au"));
    }
}
