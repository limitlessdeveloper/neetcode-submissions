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