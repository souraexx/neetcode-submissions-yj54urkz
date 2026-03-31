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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode temp = root;
        TreeNode prev = temp;
        while (temp!=null) {
            prev = temp;
            if (val > temp.val) {
                temp = temp.right;
            } else if (val < temp.val) {
                temp = temp.left;
            }
        }
        TreeNode result = new TreeNode(val);
        if (val>prev.val) {
            prev.right = result;
        } else {
            prev.left = result;
        }
        return root;
    }
}