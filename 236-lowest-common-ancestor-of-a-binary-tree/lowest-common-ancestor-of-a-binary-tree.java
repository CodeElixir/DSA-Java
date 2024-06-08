/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lcaHelper(root, p, q);
    }

    private TreeNode lcaHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            // lcaHelper(root.left, p, q);
            // lcaHelper(root.right, p, q);
            return root;
        }

        TreeNode l = lcaHelper(root.left, p, q);
        TreeNode r = lcaHelper(root.right, p, q);
        if (l != null && r != null) {
            return root;
        } else {
            return l != null ? l : r; 
        }
    }
}