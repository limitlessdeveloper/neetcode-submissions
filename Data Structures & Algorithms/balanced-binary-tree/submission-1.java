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
    public boolean isBalanced(TreeNode root) {
        int val = height(root);
        return val == -1 ? false: true;
    }

    public int height(TreeNode root){
        
        if(root == null){
            return 0;
        }

        int lh = height(root.left);
        // System.out.println(lh);
        if(lh == -1){
            return -1;
        }

        int rh = height(root.right);
        // System.out.println(rh);
        if(rh == -1){
            return -1;
        }

        if(Math.abs(rh - lh)>1){
            return -1;
        }

        return 1 + Math.max(lh, rh);
    }
}
