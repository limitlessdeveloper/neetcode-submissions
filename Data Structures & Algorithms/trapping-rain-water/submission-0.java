class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int maxRight[] = new int[n];
        maxRight[n-1] = height[n-1];
        int maxLeft[] = new int[n];
        maxLeft[0] = height[0]; 
        int totalTrap = 0;
        for(int i=1;i<n;i++){
            maxLeft[i] = Math.max(maxLeft[i-1], height[i]);
            maxRight[n-i-1] = Math.max(height[n-i-1], maxRight[n-i]);
        }

        for(int i=0; i<n; i++){
            int minEle = Math.min(maxLeft[i], maxRight[i]);
            totalTrap += (minEle-height[i]); 
        }
        return totalTrap;
    }
}