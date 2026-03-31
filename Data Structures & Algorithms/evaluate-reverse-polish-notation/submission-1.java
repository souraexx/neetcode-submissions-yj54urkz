class Solution {
    public int evalRPN(String[] tokens) {
        int result = 0;
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        Stack<Integer> prefixNotation = new Stack<>();
        for (int i=0; i<tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || 
            tokens[i].equals("*") || tokens[i].equals("/")) {
                int b = prefixNotation.pop();
                int a = prefixNotation.pop();
                result = computeOperation(a,b,tokens[i]);
                prefixNotation.push(result);
            } else {
                prefixNotation.push(Integer.parseInt(tokens[i]));
            }
        }
        return result;
    }
    private int computeOperation(int a, int b, String operator) {
        if (operator.equals("+")) {
            return a+b;
        } else if (operator.equals("-")) {
            return a-b;
        } else if (operator.equals("*")) {
            return a*b;
        } else {
            return a/b;
        }
    }
}
