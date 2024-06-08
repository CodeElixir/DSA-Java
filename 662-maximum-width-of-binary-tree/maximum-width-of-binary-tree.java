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

    class Pair {
        int id;
        TreeNode node;
        Pair(int id, TreeNode node) {
            this.id = id;
            this.node = node;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        Deque<Pair> queue = new ArrayDeque<>();
        queue.addLast(new Pair(0, root));
        while (!queue.isEmpty()) {
            int count = queue.size();
            int firstId = 0;
            int lastId = 0;
            int minId = queue.peekFirst().id;
            for (int i = 0; i < count; i++) {
                Pair pair = queue.removeFirst();
                int currId = pair.id - minId;
                if (i == 0) firstId = currId;
                if (i == count - 1) lastId = currId;
                if (pair.node.left != null) {
                    queue.addLast(new Pair(2 * currId + 1, pair.node.left));
                }

                if (pair.node.right != null) {
                    queue.addLast(new Pair(2 * currId + 2, pair.node.right));
                }
            }
            maxWidth = Math.max(maxWidth, lastId - firstId + 1);
        }
        return maxWidth;
    }
}