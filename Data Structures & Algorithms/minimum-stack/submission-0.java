class MinStack {
    private int topInd;
    private int stack[] = new int[30000];
    private int minStack[] = new int[30000];
    private int minval = Integer.MAX_VALUE;
    public MinStack() {
        this.topInd = -1;
    }
    
    public void push(int val) {
        this.stack[++topInd] = val;
        if(this.minval >= val){
            this.minval=val;
        }
        this.minStack[topInd] =  this.minval;      
        // System.out.println("topInd: "+ topInd + " stack: "+ Arrays.toString(stack));
        // System.out.println("topInd: "+ topInd + " minstack: "+ Arrays.toString(minStack));
    }
    
    public void pop() {
        this.topInd--;
        if(this.topInd==-1){
            this.minval = Integer.MAX_VALUE;    
        }
        else{
            this.minval = this.minStack[topInd];
        }
    }
    
    public int top() {
        return this.stack[topInd];
    }
    
    public int getMin() {
        return this.minStack[topInd];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */