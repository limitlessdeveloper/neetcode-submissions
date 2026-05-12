class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        Map<Integer, List<Integer>> freqMap = new HashMap<>();
        for(int freq: map.keySet()){
            List<Integer> tempList= freqMap.getOrDefault(map.get(freq), new ArrayList<>());
            tempList.add(freq);
            freqMap.put(map.get(freq), tempList);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n:freqMap.keySet()){
            List<Integer> tempList = freqMap.get(n);
            for(int nu : tempList){
                if(pq.size()==k){
                    if(pq.peek()<n){
                        pq.poll();
                        pq.add(n);
                    }   
                }
                else{
                    pq.add(n);
                }
            }
        }
        int result[] = new int[k];
        int h=0;
        // System.out.println(pq);
        // System.out.println(freqMap);
        // System.out.println(map);
        int lastfreq = 0;
        while(h<k){
            if(lastfreq == pq.peek()){
                pq.poll();
                continue;
            }
            lastfreq = pq.poll();
            for(int tempNum : freqMap.get(lastfreq)){
                result[h] = tempNum;
                h++;
            }   
        }
        return result;
    }
}