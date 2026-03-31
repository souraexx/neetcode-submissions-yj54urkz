class Solution {
    class Pair {
        String element;
        double weight;
        Pair (String element, double weight) {
            this.element = element;
            this.weight = weight;
        }
    }
    public double[] calcEquation(List<List<String>> equations, 
    double[] values, List<List<String>> queries) {
        int n = equations.size();
        Map<String, List<Pair>> graph = new HashMap<>();

        for (int i=0;i<n;i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(a).add(new Pair(b, val));
            graph.get(b).add(new Pair(a, (1/val)));
        }

        double result[] = new double[queries.size()];

        for (int i=0;i<queries.size();i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if (!graph.containsKey(a) || !graph.containsKey(b)) {
                result[i] = -1;
                continue;
            }
            Set<String> visited = new HashSet<>();
            result[i] = dfs(a, b, visited, graph);
        }

        return result;
    }
    double dfs(String src, String dest, Set<String> visited, Map<String, List<Pair>> graph) {
        if (src.equals(dest)) {
            return 1;
        }
        visited.add(src);
        for (Pair neighbour : graph.get(src)) {
            String element = neighbour.element;
            double weight = neighbour.weight;
            if (!visited.contains(element)) {
                double result = dfs(element, dest, visited, graph);
                if (result !=-1) {
                    return result * weight;
                }
            }
        }
        return -1.0;
    }
    
}