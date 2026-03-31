class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0;i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }   
        int indegree[] = new int[numCourses];
        for (int pre[]: prerequisites) {
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<numCourses;i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int num = 0;
        while(!queue.isEmpty()) {
            int element = queue.poll();
            num++;
            for(int i : adj.get(element)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        return (num==numCourses);

    }
}
