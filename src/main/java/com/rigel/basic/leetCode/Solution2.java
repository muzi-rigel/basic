package com.rigel.basic.leetCode;

import java.util.Arrays;

public class Solution2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        int carry = 0;
        ListNode curr = l3;

        while (l1 != null || l2 != null) {
            curr.next = new ListNode(0);
            curr = curr.next;

            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            curr.val = sum % 10;
            carry = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) {
            curr.next = new ListNode(carry);
        }
        return l3.next;
    }

    //过不去 int长度不够 long好像也是
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        String str1 = "";
        while (l1 != null) {
            str1 += l1.val;
            if (null != l1.next) {
                l1 = l1.next;
            } else {
                break;
            }
        }
        String str2 = "";
        while (l2 != null) {
            str2 += l2.val;
            if (null != l2.next) {
                l2 = l2.next;
            } else {
                break;
            }
        }
        Long a = 0l;
        if (!str1.equals("")) {
            a = Long.parseLong(str1);
        }
        Long b = 0l;
        if (!str2.equals("")) {
            b = Long.parseLong(str2);
        }
        String c = a + b + "";
        String[] split = c.split("");
        ListNode l3 = new ListNode(0);
        ListNode curr = l3;
        for (int i = 0; i < split.length; i++) {
            String s = split[split.length - 1 - i];
            curr.val = (int) Long.parseLong(s);
            if (i != split.length - 1) {
                curr.next = new ListNode(0);
                curr = curr.next;
            }

        }
        return l3;
    }

    public static void main(String[] args) {
//        [2,4,3]
//        [5,6,4]
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//
//
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);


        ListNode l2 = new ListNode(1);
////        ListNode l3 = addTwoNumbers(l1, l2);
        ListNode l3 = addTwoNumbers2(l1, l2);
        System.out.println(l3);


    }
}
