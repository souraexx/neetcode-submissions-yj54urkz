class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] rank = new int[26];
        for (int i=0;i<order.length();i++) {
            rank[(order.charAt(i)-'a')] = i;
        }
        for (int i=0; i<words.length-1;i++) {
            if (!isInOrder(words[i], words[i+1], rank)) {
                return false;
            }
        }
        return true;
    }
    private boolean isInOrder(String a, String b, int rank[]) {
        int len = Math.min(a.length(), b.length());
        
        for (int i=0;i<len;i++) {
            char x = a.charAt(i);
            char y = b.charAt(i);
            if (x!=y) {
                return rank[x-'a']<rank[y-'a'];
            }
        }

        return a.length()<=b.length();
    }
}