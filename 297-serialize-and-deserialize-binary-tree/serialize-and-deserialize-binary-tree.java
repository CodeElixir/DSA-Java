/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Deque<TreeNode> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if (node == null) {
                res.append("null,");
            } else {
                res.append(node.val + ",");
                queue.addLast(node.left);
                queue.addLast(node.right);
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }
        String[] arr = data.split(",");
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        queue.addLast(root);
        for (int i = 1; i < arr.length - 1; i = i + 2) {
            TreeNode node = queue.removeFirst();
            String str1 = arr[i];
            String str2 = arr[i + 1];
            if (!str1.equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(str1));
                node.left = left;
                queue.addLast(left);
            }

            if (!str2.equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(str2));
                node.right = right;
                queue.addLast(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));