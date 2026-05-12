class Solution {
    public int asciiToAdd = (int)'a' - (int)'A';
    public boolean isPalindrome(String s) {
        int len = s.length()-1;
        int i=0;
        int j=len;
        while(i<j){
            
            char ch1 = realVal(s.charAt(i));
            while(ch1=='*' && i<j){
                i++;
                ch1 = realVal(s.charAt(i));
            }

            char ch2 = realVal(s.charAt(j));
            while(ch2=='*' && i<j){
                j--;
                ch2 = realVal(s.charAt(j));
            }
            if(ch1!=ch2){
                return false;
            }
            i++;
            j--;

        }

        return true;
    }

    public char realVal(char ch){
        if(Character.isDigit(ch)){
            return ch;
        }
        if((int)ch-(int)'A'>=0 && (int)'Z'-(int)ch >=0){
            return (char)((int)ch+asciiToAdd);
        }
        if((int)ch-(int)'a'>=0 && (int)'z'-(int)ch >=0){
            return ch;
        }
        return '*';
    }
}