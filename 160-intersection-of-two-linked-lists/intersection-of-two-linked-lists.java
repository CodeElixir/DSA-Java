/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n1 = 0;
        int n2 = 0;
        ListNode curr1 = headA;
        ListNode curr2 = headB;

        while (curr1 != null) {
            n1++;
            curr1 = curr1.next;
        }

        while (curr2 != null) {
            n2++;
            curr2 = curr2.next;
        }

        int lengthDiff = Math.abs(n1 - n2);
        if (n1 > n2) {
            return getIntersectionNode(headA, headB, lengthDiff);
        } 
        return getIntersectionNode(headB, headA, lengthDiff);
    }

    private ListNode getIntersectionNode(ListNode headA, ListNode headB, int lengthDiff) {
        ListNode curr1 = headA;
        ListNode curr2 = headB;
        while (lengthDiff != 0) {
            curr1 = curr1.next;
            lengthDiff--;
        }

        while (curr1 != null && curr2 != null && curr1 != curr2) {
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        if (curr1 == curr2) {
            return curr1;
        }
        return null;
    }
}