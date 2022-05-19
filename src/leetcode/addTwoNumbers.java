package leetcode;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class addTwoNumbers {
    //https://leetcode.com/problems/add-two-numbers/
    public static void main(String[] args) {

    }

    @Test
    public void myTest() {
        Solution sol = new Solution();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = sol.addTwoNumbers(l1, l2);
        String str = "";

        while (result != null) {
            str += result.val + " ";
            result = result.next;
        }
        str = str.trim();
        assertTrue(str.equals("7 0 8"));

    }

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

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode origin = new ListNode(0);
            ListNode answer = origin;
            while (l1 != null || l2 != null) {
                int val1 = l1 == null ? 0 : l1.val;
                int val2 = l2 == null ? 0 : l2.val;

                if (answer == null) answer = new ListNode(0);

                answer.val += (val1 + val2);
                answer.next = new ListNode((answer.val) / 10);
                answer.val %= 10;

                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;

                if (l1 == null && l2 == null && answer.next != null && answer.next.val == 0) {
                    answer.next = null;
                    break;
                }

                answer = answer.next;
            }
            return origin;
        }
    }
}
