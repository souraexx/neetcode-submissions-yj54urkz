class MyStack {
    Queue<Integer> stackss = new LinkedList<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
        stackss.offer(x);
        for (int i=0; i<stackss.size()-1; i++) {
            stackss.offer(stackss.poll());
        }
    }
    
    public int pop() {
        return stackss.poll();
    }
    
    public int top() {
        return stackss.peek();
    }
    
    public boolean empty() {
        return stackss.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */