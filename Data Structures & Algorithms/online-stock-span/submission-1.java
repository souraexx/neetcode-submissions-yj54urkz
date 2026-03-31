class StockSpanner {

    Stack<int[]> stack; // price , index
    int index;
    public StockSpanner() {
        stack = new Stack<>();
        index = -1;
    }
    
    public int next(int price) {
        index++;
        while(!stack.isEmpty() && price>=stack.peek()[0]) {
            stack.pop();
        }
        int prevIndex = stack.isEmpty()?-1:stack.peek()[1];
        int span = index-prevIndex;
        stack.push(new int[]{price, index});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */