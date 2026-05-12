class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            Comparator.comparing(ele -> map.get(ele)) // min frequency at top
        );

        for(int ele: map.keySet()){
            pq.offer(ele);
            if(pq.size()>k){
                pq.poll();
            }
        }

        int result[] = new int[k];
        int h=0;
        while(h<k){
            result[h] = pq.poll();
            h++;
        }
        return result;
    }
}