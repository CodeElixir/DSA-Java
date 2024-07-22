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
    public boolean isValidBST(TreeNode root) {
        // return isValidBST(root, new long[]{Long.MIN_VALUE});
        if (root == null) {
            return true;
        }
        TreeNode pre = null;
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }
    
    // Recursive
    private boolean isValidBST(TreeNode root, long[] prevMax) {
        if (root == null) {
            return true;
        }
        boolean isValidBSTLeft = isValidBST(root.left, prevMax);
        if (!isValidBSTLeft) {
            return false;
        } else {
            if (root.val <= prevMax[0]) {
                return false;
            } else {
                prevMax[0] = root.val;
            }
        }
        return isValidBST(root.right, prevMax);
    }

}