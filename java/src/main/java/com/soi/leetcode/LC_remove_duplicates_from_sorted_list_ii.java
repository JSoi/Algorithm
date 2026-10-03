package com.soi.leetcode;

public class LC_remove_duplicates_from_sorted_list_ii {
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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode d = new ListNode();
        d.next = head;
        ListNode p = d;
        ListNode h = head;
        if (head == null || head.next == null)
            return head;
        while (h != null && h.next != null) {
            if (h.val == h.next.val) {
                while (h.next != null && h.val == h.next.val) {
                    h = h.next;
                }
                p.next = h.next;
            } else {
                p = p.next;
            }
            h = h.next;
        }
        return d.next;
    }
}
