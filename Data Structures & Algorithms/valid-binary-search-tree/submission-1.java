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
    public boolean isValidBST(TreeNode root) {
        return isValid(Integer.MIN_VALUE, Integer.MAX_VALUE, root);
    }
    private boolean isValid(int min, int max, TreeNode root) {
        if (root == null) return true;
        if (root.val<=min || root.val>=max) return false;
        return isValid(min,root.val,root.left) && isValid(root.val, max, root.right);
    }
}
