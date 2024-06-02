/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (isBalancedHelper(root) < 0) {
            return false;
        }
        return true;     
    }

    private int isBalancedHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = isBalancedHelper(root.left);
        if (leftHeight < 0) {
            return -1;
        }
        int rightHeight = isBalancedHelper(root.right);
        if (rightHeight < 0) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return 1 + Math.max(leftHeight, rightHeight);
        }

    }
}