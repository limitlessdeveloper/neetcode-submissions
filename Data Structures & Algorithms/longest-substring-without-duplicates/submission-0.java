class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> indMap = new HashMap<>();
        int l = s.length();
        if(l==0 || l==1){
            return l;
        }
        int maxLength = 0;
        int si = 0;
        int i=0;
        indMap.put(s.charAt(i), i);
        for(i=1; i<l; i++){
            char c= s.charAt(i);
            if(indMap.get(c)!=null){
                int tempInd = indMap.get(c);
                maxLength = Math.max(i-si, maxLength);
                si = Math.max(tempInd+1, si);// tricky part always check is si is greater than tempInd;
            }
            indMap.put(c, i);
        }
        maxLength = Math.max(i-si, maxLength);
        return maxLength;
    }
}