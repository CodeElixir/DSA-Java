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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode evenStart = null;
        ListNode evenEnd = null;
        ListNode oddStart = null;
        ListNode oddEnd = null;
        ListNode curr = head;
        int pos = 0;
        while (curr != null) {
            if (pos % 2 == 0) {
                if (evenStart == null) {
                    evenStart = evenEnd = curr;
                } else {
                    evenEnd.next = curr;
                    evenEnd = curr;
                }
            } else {
                if (oddStart == null) {
                    oddStart = oddEnd = curr;
                } else {
                    oddEnd.next = curr;
                    oddEnd = curr;
                }                
            }
            curr = curr.next;
            pos++;
        }
        oddEnd.next = null;
        evenEnd.next = oddStart;
        return evenStart;
    }
}