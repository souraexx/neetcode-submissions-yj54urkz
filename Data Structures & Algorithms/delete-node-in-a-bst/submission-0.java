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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        
        TreeNode temp = root;
        if (key > root.val) {
            root.right = deleteNode(root.right , key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            root.val = findLargestAtLeft(root.left);
            root.left = deleteNode(root.left, root.val);
        }
        return root;
    }
    int findLargestAtLeft(TreeNode root) {
        if (root.right == null) return root.val;
        return findLargestAtLeft(root.right);
    }
}