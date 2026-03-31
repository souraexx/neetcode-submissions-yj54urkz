class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int result[] = new int[n];
        result[n-1] = 0;
        Stack<Integer> nge = new Stack<>();
        for (int i=n-1; i>=0; i--) {
            while (!nge.isEmpty() && temperatures[i]>=temperatures[nge.peek()]) {
                nge.pop();
            }
            if (nge.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = nge.peek() - i;
            }
            nge.push(i);
        }
        return result;
    }
}
// 40 35 