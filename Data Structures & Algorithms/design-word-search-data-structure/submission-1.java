class WordDictionary {

    
    class Node {
        Node links[] = new Node[26];
        int countEndOfWord = 0;
        int countPrefix = 0;

        void put(char ch, Node node) {
            links[ch-'a'] = node;
        }

        Node get(char ch) {
            return links[ch-'a'];
        }

        boolean containsChar(char ch) {
            return (links[ch-'a']!=null);
        }

        int getPrefixCount() {
            return countPrefix;
        }

        int getWordCount() {
            return countEndOfWord;
        }

        void increasePrefixCount() {
            countPrefix++;
        }

        void increaseWordCount() {
            countEndOfWord++;
        }
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for (int i=0; i<word.length();i++) {
            char ch = word.charAt(i);
            if (!node.containsChar(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
            node.increasePrefixCount();
        }
        node.increaseWordCount();
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, Node node) {
        if (node == null) return false;

        if (word.length()==index) {
            return node.getWordCount() > 0;
        }

        char ch = word.charAt(index);

        if (ch=='.') {
            for (Node child : node.links) {
                if (child!=null && dfs(word, index+1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            return dfs(word, index+1, node.get(ch));
        }
    }
}
