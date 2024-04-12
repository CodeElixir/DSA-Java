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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = getMiddle(head);
        ListNode right = middle.next;
        middle.next = null;
        ListNode first = sortList(head);
        ListNode second = sortList(right);
        return merge(first, second);
    }

    private ListNode getMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode first, ListNode second) {
        if (first == null) {
            return second; 
        }

        if (second == null) {
            return first;
        }

        ListNode head = null;
        ListNode tail = null;

        if (first.val <= second.val) {
            head = tail = first;
            first = first.next;
        } else {
            head = tail = second;
            second = second.next;
        }

        while (first != null && second != null) {
            if (first.val <= second.val) {
                tail.next = first;
                tail = first;
                first = first.next;
            } else {
                tail.next = second;
                tail = second;
                second = second.next;
            }
        }

        if (first == null) {
            tail.next = second;
        } else {
            tail.next = first;
        }

        return head;
    }
}