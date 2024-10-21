/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int numNodes = 0;
        ListNode dummy = head;
        while (dummy != null) {
            dummy = dummy.next;
            numNodes++;
        }
        dummy = head;
        int remove = numNodes - n;
        if (remove == 0) {
            return head.next;
        }

        for (int i = 1; i < remove; i++) {
            dummy = dummy.next;
        }

        if (dummy.next != null) {
            dummy.next = dummy.next.next; //skip the next node;
        }

        return head;
    }
}