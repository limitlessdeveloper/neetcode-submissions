class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        // Through CP:
        int max = nums[0];
        int min = nums[0];

        Set<Integer> set= new HashSet<>();
        for(int n:nums){
            max = Math.max(max, n);
            min = Math.min(min, n);
            set.add(n);
        }
        if(max<10000){
            int totalRange = max-min+1;
            boolean rangeArr[] = new boolean[totalRange];
            for(int n: nums){
                rangeArr[n-min] = true;
            }
            int totalMax = 0;
            int localMax = 0;
            for(int i=0; i<totalRange; i++){
                if(rangeArr[i]){
                    localMax++;
                }
                else{
                    totalMax = Math.max(totalMax, localMax);
                    localMax = 0;
                }
            }
            totalMax = Math.max(totalMax, localMax);    
            return totalMax;
        } 
        
        int maxL = 0;
        for(int n: set){
           if(!set.contains(n-1)){
                int len = 1;
                int curr = n;
                while(set.contains(curr+1)){
                    curr++;
                    len++;
                }
                maxL = Math.max(maxL, len);
           }
        }
        return maxL;
    }
}