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
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        TreeNode temp = root;
        while(node!=null || !stack.isEmpty()) {
            if (node!=null) {
                stack.push(node);
                node=node.left;
            } else {
                temp = stack.peek();
                temp = temp.right;
                if (temp == null) {
                    temp = stack.pop();
                    result.add(temp.val);
                    while(!stack.isEmpty() && stack.peek().right == temp) {
                        temp = stack.pop();
                        result.add(temp.val);
                    }
                } else {
                    node = temp;
                }
            }
        }
        return result; 
    }
}