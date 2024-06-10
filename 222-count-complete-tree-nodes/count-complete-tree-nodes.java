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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = 0;
        int rh = 0;
        TreeNode curr = root;
        while (curr != null) {
            curr = curr.left;
            lh++;
        }
        curr = root;
        while (curr != null) {
            curr = curr.right;
            rh++;
        }

        if (rh == lh) {
            return (1 << lh) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }

    }
}