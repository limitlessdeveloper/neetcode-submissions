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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> resultList = new ArrayList<>();
        if(root == null){
            return resultList;
        }
        Queue<TreeNode> queue= new LinkedList<>(); // offer // peek // poll // fifo
        
        queue.offer(root);
        while(!queue.isEmpty()){
            
            int i = queue.size();
            List<Integer> tempResult = new ArrayList<>();
            
            while( i>0 ){
                TreeNode tempNode = queue.poll();
                tempResult.add(tempNode.val);
                TreeNode tempLeft = tempNode.left;
                TreeNode tempRight = tempNode.right;
                if(tempLeft != null){
                    queue.offer(tempLeft);    
                }
                if(tempRight != null){
                    queue.offer(tempRight);
                }
                i--;
            }
            
            resultList.add(tempResult);
        }
        return resultList;
    }
}
