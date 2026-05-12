class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            } 
            
            if (nums[i] > 0){
                break;
            }// Early exit: smallest possible sum already > 0

            int target = 0 - nums[i];
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                int tempSum = nums[j] + nums[k];
                if(tempSum==target){
                    
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j<k && nums[j]==nums[j+1]){
                        j++;
                    }
                    while(j<k && nums[k]==nums[k-1]){
                        k--;
                    }
                    j++;
                    k--;
                }
                else if(tempSum>target){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return result;
    }
}