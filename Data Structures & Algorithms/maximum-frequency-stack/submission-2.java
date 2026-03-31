class FreqStack {

    Map<Integer, Integer> freqMap; //number, its frequency
    Map<Integer, Stack<Integer>> freqStack; // frequency, list of numbers with that frequency
    int maxFreq;

    public FreqStack() {
        freqMap = new HashMap<>();
        freqStack = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {

        int f = freqMap.getOrDefault(val, 0)+1;
        freqMap.put(val, f);

        maxFreq = Math.max(f, maxFreq);
        
        Stack<Integer> stack; 
        if (freqStack.containsKey(f)) {
            stack = freqStack.get(f);
            stack.push(val);
        } else {
            stack = new Stack<>();
            stack.push(val);
        }
        freqStack.put(f, stack);
        // cleaner way to do this
        // add val to the stack of its frequency
        // freqStack.computeIfAbsent(f, k -> new Stack<>()).push(val);

    }
    
    public int pop() {
        Stack<Integer> stack = freqStack.get(maxFreq);
        int val = stack.pop();

        freqMap.put(val, freqMap.get(val)-1);

        if (stack.isEmpty()) {
            maxFreq--;
        }

        return val;

    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */