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
    public int maxPathSum(TreeNode root) {
        int[] maxPath = new int[1];
        maxPath[0] = -10001;
        maxPathSum(root, maxPath);
        return maxPath[0];
    }

    private int maxPathSum(TreeNode root, int[] maxPath) {
        if (root == null) {
            return 0;
        }

        int leftPathSum = Math.max(0, maxPathSum(root.left, maxPath));
        int rightPathSum = Math.max(0, maxPathSum(root.right, maxPath));
        maxPath[0] = Math.max(maxPath[0], leftPathSum + rightPathSum + root.val);
        return root.val + Math.max(leftPathSum, rightPathSum);
    }
}