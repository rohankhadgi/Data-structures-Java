package com.HackerRank;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list1 = l1;
        ListNode list2 = l2;
        ListNode list = new ListNode();
        int n = 0;
        int multiplier = 0;
        int sum = 0;
        while (list1 != null && list2 != null) {
            multiplier = (int) Math.pow(10,n);
            sum += ((list1.val + list2.val) * multiplier);
            System.out.println(sum);
            list1 = list1.next;
            list2 = list2.next;
            n++;
        }
        while (list != null) {
            int value = sum % 10;
            list = new ListNode(value, null);
            list = list.next;
            sum -= value;
            sum /= 10;
        }
        return list;
    }
}
