class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        int maxlength = 0;
        for(int s:set){
            int currLen = 1;
            int curr = s;
            if(set.contains(s-1)){
                continue;
            }
            while(set.contains(curr+1)){
                currLen++;
                curr++;
            }
            maxlength = Math.max(currLen, maxlength);
        }
        return maxlength;
    }
}