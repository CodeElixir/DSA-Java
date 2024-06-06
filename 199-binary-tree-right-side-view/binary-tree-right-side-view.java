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
    public List<Integer> rightSideView(TreeNode root) {
        // Level Order
        // List<Integer> list = new ArrayList<>();
        // if (root == null) {
        //     return list;
        // }
        // Deque<TreeNode> queue = new ArrayDeque<>();
        // queue.addLast(root);
        // while (!queue.isEmpty()) {
        //     int count = queue.size();
        //     for (int i = 0; i < count; i++) {
        //         TreeNode node = queue.removeFirst();
        //         if (i == count - 1) {
        //             list.add(node.val);
        //         }
        //         if (node.left != null) {
        //             queue.addLast(node.left);
        //         }

        //         if (node.right != null) {
        //             queue.addLast(node.right);
        //         }

        //     }
        // }
        // return list;

        // Reverse Preorder (Root Right Left)
        List<Integer> list = new ArrayList<>();
        reversePreorder(root, 0, list);
        return list;
    }

    private void reversePreorder(TreeNode root, int level, List<Integer> rightSideViewNodes) {
        if (root == null) {
            return;
        }

        if (rightSideViewNodes.size() == level) {
            rightSideViewNodes.add(root.val);
        }

        reversePreorder(root.right, level + 1, rightSideViewNodes);
        reversePreorder(root.left, level + 1, rightSideViewNodes);

    }
}