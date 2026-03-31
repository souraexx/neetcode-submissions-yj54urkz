class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> calculate = new Stack<>();
        for (int i=0; i<operations.length; i++) {
            if (operations[i].equals("+") && !calculate.isEmpty() && calculate.size()>=2) {
                int second = calculate.pop();
                int first = calculate.pop();
                int third = second + first;
                calculate.push(first);
                calculate.push(second);
                calculate.push(third);
            } else if (operations[i].equals("D") && !calculate.isEmpty()) {
                int score = calculate.peek() * 2;
                calculate.push(score);
            } else if (operations[i].equals("C") && !calculate.isEmpty()) {
                calculate.pop();
            } else {
                calculate.push(Integer.parseInt(operations[i]));
            }
        }
        int sum = 0;
        while(!calculate.isEmpty()) {
            sum+= calculate.pop();
        }
        return sum;
    }
}