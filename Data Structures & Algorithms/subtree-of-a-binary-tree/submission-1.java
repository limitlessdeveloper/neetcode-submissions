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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;           // ran out of nodes to check

        // Is the tree rooted HERE identical to subRoot?
        if (isSameTree(root, subRoot)) return true;

        // Otherwise, check left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;   // both empty → match
        if (a == null || b == null) return false;  // one empty → mismatch
        if (a.val != b.val) return false;          // values differ → mismatch

        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }
}
