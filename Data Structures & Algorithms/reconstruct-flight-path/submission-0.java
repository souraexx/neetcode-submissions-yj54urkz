class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    List<String> result = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket: tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).offer(ticket.get(1));
        }

        dfs("JFK");

        Collections.reverse(result);

        return result;
    }
    void dfs(String path) {
        PriorityQueue<String> pq = graph.get(path);

        while (pq!=null && !pq.isEmpty()) {
            String polledPath = pq.poll();
            dfs(polledPath);
        }

        result.add(path);
    }
}
