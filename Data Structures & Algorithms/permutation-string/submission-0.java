class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int windowL = s1.length();
        int arr[] = new int[26];
        for(char ch: s1.toCharArray()){
            int tempInd = (int)(ch-'a');
            arr[tempInd]++;
        }

        for(int i=0; i<s2.length(); i++){
            if(arr[(int)(s2.charAt(i)-'a')] != 0){
                int tempL = i+windowL;
                if(tempL>s2.length()){
                    return false;
                }
                else{
                    int temparr[] = new int[26];
                    int j = i;
                    while(j<tempL && arr[(int)(s2.charAt(j)-'a')] != 0){
                        temparr[(int)(s2.charAt(j)-'a')]++;
                        j++;
                    }
                    if(j == tempL && Arrays.toString(temparr).equals(Arrays.toString(arr))){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}