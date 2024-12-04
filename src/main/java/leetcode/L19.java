package leetcode;

public class L19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode temp = head;
        while (true) {
            count++;
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        if (count == 1) {
            return null;
        }
        count -= n;
        if (count == 0) {
            return head.next;
        }
        temp = head;
        for (int i = 0; i < count - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
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
}
