/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> nodes =  new ArrayList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Map<TreeNode, Boolean> visitedMap = new HashMap<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        mapParentNodes(root, parentMap);
        queue.addLast(target);
        visitedMap.put(target, true);
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (dist == k) {
                break;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                TreeNode parent = parentMap.get(node);

                if (parent != null && !visitedMap.containsKey(parent)) {
                    queue.addLast(parent);
                    visitedMap.put(parent, true);
                }

                if (node.left != null && !visitedMap.containsKey(node.left)) {
                    queue.addLast(node.left);
                    visitedMap.put(node.left, true);
                }

                if (node.right != null && !visitedMap.containsKey(node.right)) {
                    queue.addLast(node.right);
                    visitedMap.put(node.right, true);
                }
            }
            dist++;
        }
        
        while (!queue.isEmpty()) {
            nodes.add(queue.removeFirst().val);
        }
        return nodes;
    }

    

    private void mapParentNodes(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        parentMap.put(root, null);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                if (node.left != null) {
                    queue.addLast(node.left);
                    parentMap.put(node.left, node);
                }

                if (node.right != null) {
                    queue.addLast(node.right);
                    parentMap.put(node.right, node);
                }
            }
        }
    }
}