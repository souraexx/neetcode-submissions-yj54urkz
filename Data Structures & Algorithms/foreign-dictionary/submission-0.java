class Solution {
    private int [] toposort(List<List<Integer>> adj, Set<Integer> validChars) {
        int indegree[] = new int[26];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i=0;i<26; i++) {
            for (int neighbours: adj.get(i)) {
                indegree[neighbours]++;
            }
        }
        for (int i=0;i<26;i++) {
            if (indegree[i]==0 && validChars.contains(i)) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int element = queue.poll();
            result.add(element);
            for (int neighbours: adj.get(element)) {
                indegree[neighbours]--;
                if (indegree[neighbours] == 0) {
                    queue.offer(neighbours);
                }
            }
        }

        if (result.size() == validChars.size()) {
            return result.stream().mapToInt(Integer::intValue).toArray();
        }
        return null;
    } 
    public String foreignDictionary(String[] words) {
        int n = words.length;
        List<List<Integer>> adj = new ArrayList<>();
        Set<Integer> validChars = new HashSet<>();

        for (int i=0;i<26;i++) {
            adj.add(new ArrayList<>());
        }

        for (String word : words) {
            for (char c : word.toCharArray()) {
                validChars.add(c - 'a');
            }
        }

        for (int i=0;i<n-1;i++) {
            String first = words[i];
            String second = words[i+1];
            int size = Math.min(first.length(), second.length());
            if (first.startsWith(second) && first.length() > second.length()) {
                return "";  // invalid
            }
            for (int j=0;j<size;j++) {
                if (first.charAt(j)!=second.charAt(j)) {
                    adj.get(first.charAt(j)-'a').add(second.charAt(j)-'a');
                    break; // important
                }
            }
        }
        int[] chars = toposort(adj, validChars);
        if (chars == null) return "";

        StringBuilder sb = new StringBuilder();
        for (int c : chars) {
            sb.append((char)(c + 'a'));
        }
        return sb.toString();
    }
}
