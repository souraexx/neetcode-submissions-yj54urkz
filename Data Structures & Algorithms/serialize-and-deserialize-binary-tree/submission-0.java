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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode leaf = queue.poll();
            if (leaf == null) {
                result.append("n ");
            } else {
                result.append(leaf.val+" ");
                queue.add(leaf.left);
                queue.add(leaf.right);
            }
        }

        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;

        Queue<TreeNode> queue = new LinkedList<>();
        String values[] = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);

        for (int i = 1; i<values.length; i++) {
            TreeNode node = queue.poll();
            if (!values[i].equals("n")) {
                node.left = new TreeNode(Integer.parseInt(values[i]));
                queue.add(node.left);
            }
            if (!values[++i].equals("n")) {
                node.right = new TreeNode(Integer.parseInt(values[i]));
                queue.add(node.right);
            }
        }

        return root;
    }

    // 1 2 3 n n 4 5 n n n n
    // 1 2 3 4 5
}
