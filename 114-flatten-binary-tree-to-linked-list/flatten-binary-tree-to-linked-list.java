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
    private TreeNode temp = null;

    // Recursion
    // public void flatten(TreeNode root) {
    //     if (root == null) {
    //         return;
    //     }

    //     flatten(root.right);
    //     flatten(root.left);

    //     root.right = temp;
    //     root.left = null;

    //     temp = root;

    // }

    // Using stack
    // public void flatten(TreeNode root) {
    //     if (root == null) {
    //         return;
    //     }

    //     Stack<TreeNode> stack = new Stack<>();
    //     stack.push(root);
    //     while (!stack.isEmpty()) {
    //         TreeNode node = stack.pop();
            
    //         if (node.right != null) {
    //             stack.push(node.right);
    //         }

    //         if (node.left != null) {
    //             stack.push(node.left);
    //         }

    //         if (!stack.isEmpty()) {
    //             node.right = stack.peek();
    //         }
    //         node.left = null;
    //     }
    // }

    // Using Morris tarversal logic
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = curr.right;
                    curr.right = curr.left;
                    curr.left = null;
                }
            }
            curr = curr.right;
        }
    }
}