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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode temp = root;
        TreeNode parent = null;
        TreeNode node = new TreeNode(val);
        while (temp != null) {
            parent = temp;
            if (val < temp.val) {
                temp = temp.left;
                continue;
            }
            temp = temp.right;
        }

        if (parent == null) {
            return node;
        }

        if (val < parent.val) {
            parent.left = node;
            return root;
        } 
        parent.right = node;
        return root;
    }
}