class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        PriorityQueue<int[]> minCapitalProfit = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>((a,b)->b-a);

        for (int i=0; i<profits.length; i++) {
            minCapitalProfit.offer(new int[]{capital[i], profits[i]});
        }

        while (k>0) {
            while(!minCapitalProfit.isEmpty() && minCapitalProfit.peek()[0] <= w) {
                int[] project = minCapitalProfit.poll();
                maxProfit.offer(project[1]);
            }

            if (maxProfit.isEmpty()) break;

            w+= maxProfit.poll();
            k--;
        }

        return w;
    }
}