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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        postorderTraversal(postorder, root);
        return postorder;       
    }

    private void postorderTraversal(List<Integer> postorder, TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        TreeNode temp = null;
        // Stack<TreeNode> stack2 = new Stack<>();
        TreeNode node = root;
        while (true) {
            if (node != null) {
                stack1.push(node);
                node = node.left;
            } else {
                if (stack1.isEmpty()) {
                    break;
                }
                TreeNode node1 = stack1.peek();
                if (node1.right == null) {
                    postorder.add(node1.val);
                    temp = stack1.pop();
                } else {
                    if (temp == null || temp != node1.right) {
                        node = node1.right;
                    } else {
                        postorder.add(node1.val);
                        temp = stack1.pop();
                    }
                }
            }
        }
    }
}