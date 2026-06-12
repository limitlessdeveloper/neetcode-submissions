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
    private  int maxheight = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxheight;
    }

    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        maxheight = Math.max(maxheight, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
