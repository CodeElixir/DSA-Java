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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int count = queue.size();
            Integer[] levelNodes = new Integer[count];
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.removeFirst();
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }

                if (reverse) {
                    levelNodes[count - i - 1] = node.val;
                } else {
                    levelNodes[i] = node.val;
                }
            }
            reverse = !reverse;
            list.add(Arrays.asList(levelNodes));
        }
        return list;
    }
}