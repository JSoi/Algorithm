package com.soi.leetcode;

public class LC_876 {
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (true) {
            count++;
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        count /= 2;
        for (int i = 0; i < count; i++) {
            head = head.next;
        }
        return head;
    }

    public static class ListNode {
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
