class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int i=0;
        int l = s.length();
        while(i<l){
            if(stack.isEmpty()){
                if(s.charAt(i)=='}' || s.charAt(i)==']' || s.charAt(i)==')'){
                    return false;
                }
                stack.push(s.charAt(i));
            }
            else{
                if((stack.peek()=='{' && s.charAt(i)=='}') || 
                    (stack.peek()=='[' && s.charAt(i)==']') ||
                    (stack.peek()=='(' && s.charAt(i)==')')){
                        stack.pop();
                }
                else if(s.charAt(i)=='{' || s.charAt(i)=='[' || s.charAt(i)=='('){
                    stack.push(s.charAt(i));
                }
                else{
                    return false;
                }
            }
            i++;
        }
        if(stack.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}
