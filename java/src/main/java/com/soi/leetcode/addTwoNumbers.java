package com.soi.leetcode;



public class addTwoNumbers {
    //https://leetcode.com/problems/add-two-numbers/
    public static void main(String[] args) {

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
