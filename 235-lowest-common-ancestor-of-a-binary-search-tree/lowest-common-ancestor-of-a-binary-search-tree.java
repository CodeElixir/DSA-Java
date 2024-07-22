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
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode ds1 = lowestCommonAncestor(root.left, p, q);
        TreeNode ds2 = lowestCommonAncestor(root.right, p, q);
        
        if (ds1 != null && ds2 != null) {
            return root;
        }

        if (ds1 == null) {
            return ds2;
        } else return ds1;

    }

     
}