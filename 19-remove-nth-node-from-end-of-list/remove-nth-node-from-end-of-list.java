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
        if (head.next == null) {
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        for (int i = 1; i <= n; i++) {
            second = second.next;
        }
        while (second != null && second.next != null) {
            second = second.next;
            first = first.next;
        }
        if (second == null) {
            return head.next;
        } else {
            first.next = first.next.next;
        }
        return head;
    }
}