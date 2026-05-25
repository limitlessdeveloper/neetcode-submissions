class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int maxHeight = 0;
        
        while(i<j){
            int length = j-i;
            int currHeight = Math.min(height[i], height[j]);
            maxHeight = Math.max(maxHeight, length*currHeight);
            if(height[i]<=height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return maxHeight;
    }
}

// 1 8 8 8 8 8 8 8 8
// 8 8 8 8 8 8 8 7 7