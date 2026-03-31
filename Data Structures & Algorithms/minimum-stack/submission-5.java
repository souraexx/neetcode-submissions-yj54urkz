class MinStack {

    Stack<Long> minStack;
    long min;

    public MinStack() {
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        if (minStack.isEmpty()) {
            minStack.push((long)val);
            min = val;
        } else if (val<min) {
            long encodedValue = 2L*val - min;
            min = val;
            minStack.push(encodedValue);
        } else {
            minStack.push((long)val);
        }
    }
    
    public void pop() {
        long poppedVal = minStack.pop();
        if (poppedVal<min) {
            long previousMin = 2*min - poppedVal;
            min = previousMin;
        }
    }
    
    public int top() {
        long peekedVal = minStack.peek();
        if (peekedVal < min) {
            return (int)min;
        } else {
            return (int)peekedVal;
        }
    }
    
    public int getMin() {
        return (int)min;
    }
}
