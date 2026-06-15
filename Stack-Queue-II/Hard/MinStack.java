class MinStack {
    Stack<int[]> stk;
    int min;
    public MinStack() {
        stk = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int value) {
        if(stk.isEmpty()){
            stk.push(new int[]{value,value});
            return;
        }
        int top = getMin();
        min = Math.min(top,value);
        stk.push(new int[]{value,min});
    }
    
    public void pop() {
        stk.pop();
    }
    
    public int top() {
        return stk.peek()[0];
    }
    
    public int getMin() {
        return stk.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
