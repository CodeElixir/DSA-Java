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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inorderMap);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart, int poEnd, Map<Integer, Integer> inorderMap) {
        if (inStart > inEnd || poStart > poEnd) {
            return null;
        }

        int rootEle = postorder[poEnd];
        int inorderIdx = inorderMap.get(rootEle);
        int nums = inorderIdx - inStart;
        TreeNode node = new TreeNode(rootEle);
        node.left = buildTree(inorder, inStart, inorderIdx - 1, postorder, poStart, poStart + nums - 1, inorderMap);
        node.right = buildTree(inorder, inorderIdx + 1, inEnd, postorder, poStart + nums, poEnd - 1, inorderMap);
        return node;
    }
}