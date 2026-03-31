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
    int maxi = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        return maxDepth(root)[1];
    }
    public int[] maxDepth(TreeNode root) {
        if (root == null)
            return new int[]{0,Integer.MIN_VALUE};
        int lh[] = maxDepth(root.left);
        int rh[] = maxDepth(root.right);
        int leftPath = Math.max(0, lh[0]);
        int rightPath = Math.max(0, rh[0]);
        int maxGainUp = root.val + Math.max(leftPath, rightPath);
        int pathSum = root.val+ leftPath+rightPath;
        int maxPathSum = Math.max(pathSum, Math.max(lh[1], rh[1]));
        return new int[]{maxGainUp, maxPathSum};
    }
}
