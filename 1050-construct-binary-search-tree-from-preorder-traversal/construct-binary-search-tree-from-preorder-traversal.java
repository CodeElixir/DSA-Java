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
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreOrder(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    private TreeNode bstFromPreOrder(int[] preorder, int upperBound, int[] i) {
        if (i[0] > preorder.length - 1 || preorder[i[0]] > upperBound) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[i[0]++]);
        root.left = bstFromPreOrder(preorder, root.val, i);
        root.right = bstFromPreOrder(preorder, upperBound, i);
        return root;
    }
}