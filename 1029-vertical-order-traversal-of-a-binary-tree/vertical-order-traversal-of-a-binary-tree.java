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

    class Tuple {
        TreeNode node;
        int x;
        int y;
        Tuple(TreeNode node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }


    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Deque<Tuple> queue = new ArrayDeque<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.addLast(new Tuple(root, 0, 0));
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                Tuple tuple = queue.removeFirst();
                int x = tuple.x;
                int y = tuple.y;
                TreeNode node = tuple.node;

                if (!map.containsKey(x)) {
                    map.put(x, new TreeMap<>());
                }

                if (!map.get(x).containsKey(y)) {
                    map.get(x).put(y, new PriorityQueue<>());
                }

                map.get(x).get(y).add(node.val);
                if (node.left != null) {
                    queue.addLast(new Tuple(node.left, x - 1, y + 1));
                }

                if (node.right != null) {
                    queue.addLast(new Tuple(node.right, x + 1, y + 1));
                }
            }
        }


        for (TreeMap<Integer, PriorityQueue<Integer>> mp : map.values()) {
            List<Integer> nodes = new ArrayList<>();
            for (PriorityQueue<Integer> pq : mp.values()) {
                while (!pq.isEmpty()) {
                    nodes.add(pq.remove());
                }
            }
            list.add(nodes);
        }
        return list;
    }
}