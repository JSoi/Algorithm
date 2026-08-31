package com.soi.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_find_the_minimum_and_maximum_number_of_nodes_between_critical_points {
    static class ListNode {
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

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> criticalPoints = new ArrayList<>();

        ListNode prev = head;
        head = head.next;
        int idx = 1;
        int minLen = Integer.MAX_VALUE;
        while (head.next != null) {
            if ((prev.val < head.val && head.next.val < head.val)
                    || (prev.val > head.val && head.next.val > head.val)) {
                criticalPoints.add(idx);
            }
            if (criticalPoints.size() > 1) {
                int gap = idx - criticalPoints.get(criticalPoints.size() - 2);
                minLen = Math.min(minLen, gap);
            }
            prev = head;
            head = head.next;
            idx++;
        }
        if (criticalPoints.size() <= 1)
            return new int[]{-1, -1};
        int n = criticalPoints.size();
        int maxLen = criticalPoints.get(n - 1) - criticalPoints.get(0);
        return new int[]{minLen, maxLen};
    }
}
