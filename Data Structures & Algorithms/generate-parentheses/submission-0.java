class Solution {

    static class State {
        int start;
        int close;
        String result;
        State(int a, int b, String x) {
            this.start = a;
            this.close = b;
            this.result = x;
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> paranthes = new ArrayList<>();
        Stack<State> validStack = new Stack<>();

        validStack.push(new State(0,0,""));

        while(!validStack.isEmpty()) {

            State currentState = validStack.pop();

            if (currentState.result.length() == 2*n) {
                String validParan = currentState.result;
                paranthes.add(validParan);
            }

            if (currentState.start<n) {
                validStack.push(new State(currentState.start+1, currentState.close, currentState.result + "("));
            }
            if (currentState.close<currentState.start) {
                validStack.push(new State(currentState.start, currentState.close+1, currentState.result + ")"));
            }
        }
        return paranthes;
    }
}
