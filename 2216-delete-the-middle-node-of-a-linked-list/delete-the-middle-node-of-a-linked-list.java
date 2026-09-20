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
    public ListNode deleteMiddle(ListNode head) {

        // If only one node
        if (head.next == null) {
            return null;
        }

        // Find length
        int length = 0;
        ListNode curr = head;

        while (curr != null) {
            length++;
            curr = curr.next;
        }

        // Middle index
        int middle = length / 2;

        // Start again from head
        curr = head;

        // Go to node before middle
        for (int i = 0; i < middle - 1; i++) {
            curr = curr.next;
        }

        // Delete middle node
        curr.next = curr.next.next;

        return head;
    }
}