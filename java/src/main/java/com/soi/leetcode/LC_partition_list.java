package com.soi.leetcode;

public class LC_partition_list {
    public ListNode partition(ListNode head, int x) {
        ListNode prevHead = new ListNode();
        ListNode nextHead = new ListNode();

        ListNode prev = prevHead;
        ListNode next = nextHead;

        while (head != null) {
            if (head.val < x) {
                prev.next = head;
                prev = prev.next;
            } else {
                next.next = head;
                next = next.next;
            }
            head = head.next;
        }
        next.next = null;
        prev.next = nextHead.next;
        return prevHead.next;
    }

    private static class ListNode {
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

}
