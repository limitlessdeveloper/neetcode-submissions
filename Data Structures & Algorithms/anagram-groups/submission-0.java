class Solution { // time: O(n*m) -> m is the length of each internal string.
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>(); // space O(n)
        for(String str: strs){ //  time: O(n)
            int arr[] = new int[26];
            for(int j = 0; j<str.length(); j++){ // time: O(m)
                arr[(int)(str.charAt(j)-'a')]++;
            }
            String tempStr = Arrays.toString(arr);
            if(map.get(tempStr)==null){
                List<String> tempList = new ArrayList<>();
                map.put(tempStr, tempList);
            }
            map.get(tempStr).add(str);
        }
        List<List<String>> result = new ArrayList<>();
        for(String key:map.keySet()){ // time: O(n) -> worst case
            result.add(map.get(key));
        }
        return result;
    }
}