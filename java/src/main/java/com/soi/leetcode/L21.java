package com.soi.leetcode;

import java.util.Collections;
import java.util.LinkedList;

public class L21 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        while (list1 != null) {
            list.add(list1.val);
            list1 = list1.next;
        }
        while (list2 != null) {
            list.add(list2.val);
            list2 = list2.next;
        }
        Collections.sort(list);
        ListNode real = new ListNode(list.get(0));
        ListNode next = real;
        for (int i = 1; i < list.size(); i++) {
            next.next = new ListNode(list.get(i));
            next = next.next;
        }
        return real;
    }
}
