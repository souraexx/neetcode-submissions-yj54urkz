class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        List<Boolean> result = new ArrayList<>();
        int[] indegree = new int[numCourses];
        List<Set<Integer>> preset = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
            preset.add(new HashSet<>());
        }
        for (int pre[]: prerequisites) {
            adj.get(pre[0]).add(pre[1]);
            indegree[pre[1]]++;
        }
        for (int i=0; i<numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int element = queue.poll();
            for (int neighbour: adj.get(element)) {
                preset.get(neighbour).add(element);
                preset.get(neighbour).addAll(preset.get(element));

                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.offer(neighbour);
                } 
            }
        }

        for (int query[]:queries) {
            int course = query[1];
            int preReq = query[0];
            result.add(preset.get(course).contains(preReq));
        }
        return result;
    }
}
// must complete ai to take bi
// ai -> bi
// indegree of bi ++