class Solution {
    public int openLock(String[] deadends, String target) {
        int moves = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        Set<String> deadList = new HashSet<>(Arrays.asList(deadends));
        if (deadList.contains("0000")) return -1;

        //BFS
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0;i<size;i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return moves;
                }
                for (String temp: getNeighbours(cur)) {
                    if (!visited.contains(temp) && !deadList.contains(temp)) {
                        queue.offer(temp);
                        visited.add(temp);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
    private List<String> getNeighbours(String cur) {
        char[] string = cur.toCharArray();
        List<String> neighbours = new ArrayList<>();
        for (int i=0; i<4;i++) {
            char num = string[i];

           //move forward 
            string[i] = num=='9'?'0':(char)(num+1);
            neighbours.add(new String(string));

            //move backward
            string[i] = num=='0'?'9':(char)(num-1);
            neighbours.add(new String(string));

            string[i]=num;
        }
        return neighbours;
    }
}