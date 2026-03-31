class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Integer indices[] = new Integer[n];
        for (int i =0;i<n;i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a,b)->position[b]-position[a]);
        Stack<Double> fleet = new Stack<>();
        for (int i=0; i<n; i++) {
            int idx = indices[i];
            double time = (double)(target-position[idx])/speed[idx];
            if (fleet.isEmpty() || time>fleet.peek()) {
                fleet.push(time);
            }
        }
        return fleet.size();
    }
}
