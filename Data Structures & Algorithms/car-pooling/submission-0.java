class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int distances[] = new int[1001];
        for (int []trip: trips) {
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];
            distances[from]+= passengers;
            distances[to]-= passengers;
        }
        int current = 0;
        for (int distance: distances) {
            current+= distance;
            if (current>capacity) {
                return false;
            }
        }
        return true;
    }
}