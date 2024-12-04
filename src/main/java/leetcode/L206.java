package leetcode;

import java.util.ArrayList;

public class L206 {
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
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ArrayList<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        ListNode answer = new ListNode(list.get(list.size()-1));
        ListNode temp = answer;
        for(int i = list.size()-2; i>=0; i--){
            temp.next = new ListNode(list.get(i));
            temp = temp.next;
        }return answer;
    }
}
