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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

        // Using level order traversal
        int level = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode front = queue.removeFirst();
                if (front.left != null) {
                    queue.add(front.left);
                }
                if (front.right != null) {
                    queue.add(front.right);
                }
            }
            level++;
        }
        return level;
    }
}