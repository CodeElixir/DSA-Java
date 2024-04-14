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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head.next == null) return head;
        ListNode curr = head;
        ListNode prevGroupTail = null;
        boolean isFirstGroup = true;
        while (curr != null) {
            if (hasNextkNodes(curr, k)) {
                ListNode temp = curr;         
                ListNode prev = null;
                int count = 0;
                while (curr != null && count < k) {
                    ListNode next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                    count++;
                }
                if (isFirstGroup) {
                    head = prev;
                    isFirstGroup = false;
                } else {
                    prevGroupTail.next = prev;
                }
                    prevGroupTail = temp;
            } else {
                prevGroupTail.next = curr;
                break;
            }
        }
        return head;
    }

    private static boolean hasNextkNodes(ListNode head, int k) {
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            k--;
            if (k <= 0) return true;
        }
        return false;
    }
}