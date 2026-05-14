class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int il = matrix.length;
        int ij = matrix[0].length;
        System.out.println(il + " " + ij);
        int i = 0;
        int j = il-1;
        while(i <= j){
            int m1 = i + (j-i)/2;
            if(matrix[m1][0]==target){
                return true;
            }
            else if(matrix[m1][0]<target){
                if(matrix[m1][ij-1]>=target){
                    return findTarget(matrix, m1, ij, target);
                }
                else{
                    i = m1+1;
                }
            }
            else{
                j = m1-1;
            }
        }
        return false;
    }
    
    public boolean findTarget(int[][] matrix, int row, int len, int target){
        int i = 0;
        int j = len-1;
        while(i <= j){
            int m = i + (j-i)/2;
            if(matrix[row][m] == target){
                return true;
            }
            else if(matrix[row][m] > target){
                j = m - 1;
            }
            else{
                i = m + 1;
            }
        }
        return false;
    }
}
