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
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        return countK(root, k).val;
    }
    private TreeNode countK(TreeNode root, int k) {
        if (root == null) return null;
        TreeNode left = countK(root.left, k);
        if (left!=null) return left;
        count++;
        if (count == k) return root;
        return countK(root.right, k);
    }
}
