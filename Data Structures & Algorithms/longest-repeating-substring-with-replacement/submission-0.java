class Solution {
    public int characterReplacement(String s, int k) {
        int ch[] = new int[26];
        int left = 0;
        int maxFreq = 0;
        int result = 0;
        for(int right=0; right<s.length(); right++){
            maxFreq = Math.max(maxFreq, ++ch[s.charAt(right) - 'A']);
            while((right-left+1) - maxFreq >k){
                ch[s.charAt(left) - 'A']--;
                left++;
            }
            result = Math.max(result, right-left+1);
        }
        return result;
    }
}