class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        
        List<Integer> bucket[] = new List[nums.length+1];
        for(int ele: map.keySet()){
            if(bucket[map.get(ele)] == null){
                bucket[map.get(ele)] = new ArrayList<>();
            } 
            bucket[map.get(ele)].add(ele);
        }
        // System.out.println(map);
        // System.out.println(Arrays.toString(bucket));
        int j=0;
        int result[] = new int[k];
        for(int h=bucket.length-1; h>=0 && j<k; h--){
            if(bucket[h]!=null){
                for(int e:bucket[h]){
                    result[j] = e;
                    j++;
                }
            }
        }
        return result;
    }
}