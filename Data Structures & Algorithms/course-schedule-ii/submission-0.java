class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[numCourses];
        int[] indegree = new int[numCourses];

        for (int i=0;i<numCourses;i++) {
            adj.add(new ArrayList<>());
        }
        for (int pre[]:prerequisites) {
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        for (int i=0;i<numCourses;i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        while(!queue.isEmpty()) {
            int element = queue.poll();
            result[count++] = element;
            for(int i:adj.get(element)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        if (count == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }
}
// to finish b, a must be done
// so b->a
// indegree of a ++