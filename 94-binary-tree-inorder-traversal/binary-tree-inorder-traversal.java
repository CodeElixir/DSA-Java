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

    // private void inorderTraversalHelper(List<Integer> inorder, TreeNode root) {
    //     if (root == null) {
    //         return;
    //     }
    //     inorderTraversalHelper(inorder, root.left);
    //     inorder.add(root.val);
    //     inorderTraversalHelper(inorder, root.right);
    // }

    // Iterative
    // private void inorderTraversalHelper(List<Integer> inorder, TreeNode root) {
    //     Stack<TreeNode> stack = new Stack<>();
    //     TreeNode node = root;

    //     while (true) {
    //         if (node != null) {
    //             stack.push(node);
    //             node = node.left;
    //         } else {
    //             if (stack.isEmpty()) {
    //                 break;
    //             }
    //             node = stack.pop();
    //             inorder.add(node.val);
    //             node = node.right;
    //         }
    //     }
    // }

    // Morris inorder traversal
    private void inorderTraversalHelper(List<Integer> inorder, TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                inorder.add(curr.val);
                curr = curr.right;
            } else {
                // Find the rightmost node in this sub tree
                TreeNode rightNode = curr.left;
                while (rightNode.right != null && rightNode.right != curr) {
                    rightNode = rightNode.right;
                }

                if (rightNode.right == null) {
                    rightNode.right = curr;
                    curr = curr.left;
                } else {
                    rightNode.right = null;
                    inorder.add(curr.val);
                    curr = curr.right;
                }
            }
        }
    }
}