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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversalHelper(inorder, root);
        return inorder;
    }

    private void inorderTraversalHelper(List<Integer> inorder, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalHelper(inorder, root.left);
        inorder.add(root.val);
        inorderTraversalHelper(inorder, root.right);
    }
}