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
    public int diameterOfBinaryTree(TreeNode root) {
        return maxDepth(root)[1];
    }
    public int[] maxDepth(TreeNode root) {
        if (root == null)
            return new int[]{0,0};
        int lh[] = maxDepth(root.left);
        int rh[] = maxDepth(root.right);
        int height = 1+Math.max(lh[0], rh[0]);
        int throughNode = lh[0]+rh[0];
        int diameter = Math.max(throughNode, Math.max(rh[1],lh[1]));
        return new int[]{height, diameter};
    }
}
