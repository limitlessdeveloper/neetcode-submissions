class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        Map<Integer, Integer> sortedMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(k).collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue,
            (e1, e2)->e1,
            LinkedHashMap::new
        ));
        
        System.out.println(map);
        System.out.println(sortedMap);

        int result[] = new int[k];
        int h=0;
        for(int num: sortedMap.keySet()){
            result[h] =  num;
            h++;
        }
        return result;
    }
}
