class TimeMap {
    private Map<String, Map<Integer, String>> mainMap = new HashMap<>();
    private Map<String, List<Integer>> timestamps = new HashMap<>();
    public TimeMap() {}
    
    public void set(String key, String value, int timestamp) {
        if(this.mainMap.get(key) == null){
            Map<Integer, String> helperMap = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            helperMap.put(timestamp, value);
            list.add(timestamp);
            mainMap.put(key, helperMap);
            timestamps.put(key, list);
        }
        else{
            Map<Integer, String> helperMap = mainMap.get(key);
            List<Integer> prevList = timestamps.get(key);
            helperMap.put(timestamp, value);
            prevList.add(timestamp);
        }
        // System.out.println(mainMap);
        // System.out.println(timestamps);
    }
    
    public String get(String key, int timestamp) {
        Map<Integer, String> helperMap = mainMap.get(key);
        List<Integer> prevList = timestamps.get(key);
        // int arr[] = helperMap.keySet().stream().mapToInt(Integer::intValue).toArray(); // this takes O(n) time so it will not be according to the description.
        
        int ind = findTarget(prevList, timestamp);
        if(ind == -1){
            return "";
        }
        return helperMap.get(ind);
    }

    public int findTarget(List<Integer> list, int timestamp){
        if(list == null || list.size() == 0 || timestamp < list.get(0)){
            return -1;
        }
        int i=0;
        int j=list.size()-1;
        while(i<j){
            int m = i + (j-i);
            if(list.get(m) == timestamp){
                return list.get(m);
            }
            else if(list.get(m)>timestamp){
                j = m-1;
            }
            else{
                i = m;
            }
        }
        return list.get(i);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */