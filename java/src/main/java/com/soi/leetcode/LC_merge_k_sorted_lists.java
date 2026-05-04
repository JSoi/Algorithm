package com.soi.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC_merge_k_sorted_lists {
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            List<Integer> values = new ArrayList<>();
            for (ListNode l : lists) {
                ListNode curr = l;
                while (curr != null) {
                    values.add(curr.val);
                    curr = curr.next;
                }
            }
            Collections.sort(values);
            ListNode head = new ListNode();
            ListNode curr = head;
            for (int v : values) {
                curr.next = new ListNode(v);
                curr = curr.next;
            }
            return head.next;
        }
    }
}
