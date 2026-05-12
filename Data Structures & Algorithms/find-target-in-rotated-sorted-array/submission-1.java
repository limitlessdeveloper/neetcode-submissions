class Solution {
    public int search(int[] nums, int target) {
        int l = nums.length;
        int i=0;
        int j=l-1;
        while(i<=j){
            int m = i + (j-i)/2;
            if(nums[m]==target){
                return m;
            }
            else if(nums[m] < nums[j]){
                if(nums[m]<target && target<=nums[j]){
                    i = m+1;
                }
                else{
                    j = m-1;
                }
            }
            else{
                if(nums[i]<=target && target<nums[m]){
                    j = m-1;
                }
                else{
                    i = m+1;
                }
            }
        }
        return -1;
    }
}