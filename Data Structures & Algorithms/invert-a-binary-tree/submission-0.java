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
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        TreeNode invertedRoot= new TreeNode(root.val);
        TreeNode head = invertedRoot;
        dfs(invertedRoot, root);
        return head;
    }
    public void dfs(TreeNode invertedRoot, TreeNode root){
        if(root.right== null && root.left == null){
            return;
        }
        if(root.right != null){
            invertedRoot.left = new TreeNode(root.right.val);
            dfs(invertedRoot.left, root.right);
        }
        if(root.left != null){
            invertedRoot.right = new TreeNode(root.left.val);
            dfs(invertedRoot.right, root.left);
        }
    }
}