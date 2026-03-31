class Solution {

    class Pair {
        String word;
        int steps;
        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>();
        for (String word:wordList) {
            words.add(word);
        }
        
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));

        while(!queue.isEmpty()) {
            Pair curr = queue.poll();
            String word = curr.word;
            int steps = curr.steps;

            if (word.equals(endWord)) { return steps; }

            for (int i=0; i<word.length(); i++) {
                for (char j='a'; j<='z'; j++) {
                    char wordArray[] = word.toCharArray();
                    wordArray[i] = j;
                    String currWord = new String(wordArray);
                    if (words.contains(currWord)) {
                        words.remove(currWord);
                        queue.offer(new Pair(currWord, steps+1));
                    }
                }
            }
        }

        return 0;

    }
}
