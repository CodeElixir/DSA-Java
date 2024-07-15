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
    public int kthSmallest(TreeNode root, int k) {
        int[] res = new int[]{0};
        kthSmallestHelper(root, k , res, new int[]{0});
        return res[0];
    }

    private void kthSmallestHelper(TreeNode root, int k, int[] res, int[] count) {
        if (root == null) {
            return;
        }

        kthSmallestHelper(root.left, k, res, count);
        count[0]++;
        if (count[0] == k) {
            res[0] = root.val;
            return;
        }
        kthSmallestHelper(root.right, k, res, count);
    }
}