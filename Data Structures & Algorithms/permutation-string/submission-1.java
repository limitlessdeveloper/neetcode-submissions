class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int windowL = s1.length();
        int arr1[] = new int[26];
        int arr2[] = new int[26];
        if(s1.length()>s2.length()){
            return false;
        }
        for(int i=0; i<windowL; i++){
            arr1[s1.charAt(i)-'a']++;
            arr2[s2.charAt(i)-'a']++;
        }
        if(match(arr1, arr2)){
            return true;
        }

        for(int i=windowL; i<s2.length(); i++){
            arr2[s2.charAt(i)-'a']++;
            arr2[s2.charAt(i-windowL)-'a']--;
            
            if(match(arr1, arr2)){
                return true;
            }
        }
        return false;
    }
    public boolean match(int arr1[], int arr2[]){
        for(int i=0; i<26; i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
}