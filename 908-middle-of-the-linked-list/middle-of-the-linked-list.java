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
    public ListNode middleNode(ListNode head) {
        /*ListNode curr = head; //find mid node then restart with curr head then find mid 0(3n/2)
        int length =0;
        while(curr != null){
           length++;
           curr = curr.next;
        }

        int mid = length/2;

        curr = head;

        for(int i = 0; i< mid;i++){
            curr = curr.next;
        }
        return curr;*/


        ListNode slow = head; // use fast and 
        ListNode fast = head;

        while( fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}