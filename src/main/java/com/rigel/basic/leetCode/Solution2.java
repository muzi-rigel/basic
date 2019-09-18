package com.rigel.basic.leetCode;

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
        ListNode l3 = addTwoNumbers(l1, l2);
        System.out.println(l3);
    }
}
