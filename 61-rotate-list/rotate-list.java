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
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            len++;
        }
        k = k % len;
        if (k == 0) {
            return head; 
        }
        head = reverseKNodes(head, -1).get(0);
        curr = head;
        List<ListNode> list = reverseKNodes(curr, k);
        ListNode newHead = list.get(0);
        head.next = reverseKNodes(list.get(1), -1).get(0);
        return newHead;
    }
    
    private List<ListNode> reverseKNodes(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>(2);
        int count = 0;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null && (k == -1 || count < k)) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        list.add(prev);
        list.add(curr);
        return list;
    }
}