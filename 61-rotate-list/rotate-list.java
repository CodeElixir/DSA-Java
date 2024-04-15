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
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }
        int len = 1;
        ListNode tail = head;
        ListNode newHead = head;
        ListNode newTail = head;

        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        k = k % len;
        if (k == 0) {
            return head;
        }

        tail.next = head;
        int count = 1;
        while (newTail != null && count < (len - k)) {
            newTail = newTail.next;
            count++;
        }
        newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}