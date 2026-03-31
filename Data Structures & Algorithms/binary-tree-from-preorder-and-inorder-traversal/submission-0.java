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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i<inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        TreeNode root = buildBinaryTree(inorderMap, preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        return root;
    }
    private TreeNode buildBinaryTree(Map<Integer, Integer> inorderMap, 
    int[] preorder, int preStart, int preEnd, int[]inorder, int inStart, int inEnd) {

        if (preStart>preEnd || inStart>inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int indexOfRoot = inorderMap.get(root.val);
        int numsLeft = indexOfRoot - inStart;

        root.left = buildBinaryTree(inorderMap, preorder, preStart+1, preStart + numsLeft,
        inorder, inStart, indexOfRoot-1);
        root.right = buildBinaryTree(inorderMap, preorder, preStart+numsLeft+1, preEnd,
        inorder, indexOfRoot+1 , inEnd);
        
        return root;
    }
}
