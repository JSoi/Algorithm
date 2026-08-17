package com.soi.leetcode;

public class LC_rotate_list {
    public static void main(String[] args) {
        LC_rotate_list lc = new LC_rotate_list();
        ListNode head = lc.new ListNode(1, lc.new ListNode(2, lc.new ListNode(3, lc.new ListNode(4, lc.new ListNode(5)))));
        int k = 2;
        ListNode result = lc.rotateRight(head, k);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int size = findLength(head);
        int rotateCount = k % size;
        if (rotateCount == 0) return head;
        int count = size - rotateCount;

        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;

        ListNode newTail = head;
        while (count-- > 1) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

    private int findLength(ListNode head) {
        if (head == null) return 0;
        return 1 + findLength(head.next);
    }

    public class ListNode {
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
