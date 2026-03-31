class PrefixTree {

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

    public PrefixTree() {
         root = new Node();
    }

    public void insert(String word) {
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
        Node node = root;
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsChar(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return (node.getWordCount()>0?true:false);
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i=0; i<prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!node.containsChar(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return (node.getPrefixCount()>0?true:false);
    }
}
