class CustomStack {
    Stack<Integer> st1,st2;
    int maxSize;
    public CustomStack(int maxSize) {
        st1 = new Stack<Integer>();
        st2 = new Stack<Integer>();
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        if(st1.size()>=maxSize)return;
        st1.push(x);
    }
    
    public int pop() {
        if(!st1.isEmpty())
        return st1.pop();
        else return -1;
    }
    
    public void increment(int k, int val) {
        while(st1.size()>k)st2.push(st1.pop());
        while(st1.size()>0)st2.push(st1.pop()+val);
        while(!st2.isEmpty())st1.push(st2.pop());
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */