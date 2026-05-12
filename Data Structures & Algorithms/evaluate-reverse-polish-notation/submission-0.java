class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str: tokens){
            // System.out.println(stack);
            if(!str.equals("*") && !str.equals("+") && !str.equals("-") && !str.equals("/")){
                int i = Integer.parseInt(str);
                stack.push(i);
            }
            else if(str.equals("-")){
                int i2 = stack.pop();
                int i1 = stack.pop();
                stack.push(i1-i2);
            }
            else if(str.equals("+")){
                int i2 = stack.pop();
                int i1 = stack.pop();
                stack.push(i1+i2);
            }
            else if(str.equals("/")){
                int i2 = stack.pop();
                int i1 = stack.pop();
                stack.push(i1/i2);
            }
            else if(str.equals("*")){
                int i2 = stack.pop();
                int i1 = stack.pop();
                // System.out.println(stack);
                stack.push(i1*i2);
            }            
        }
        return stack.pop();
    }
}