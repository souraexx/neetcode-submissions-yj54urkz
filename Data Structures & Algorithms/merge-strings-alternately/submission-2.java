class Solution {
    public String mergeAlternately(String word1, String word2) {
        int w1pointer = 0;
        int w2pointer = 0;
        int w3Length = word1.length()+word2.length();
        char w3[] = new char[w3Length];
        if (word1.length() < word2.length()) {
            for (int i = 0;i<word1.length();i++) {
                w3[i*2] = word1.charAt(i);
                w3[i*2+1] = word2.charAt(i);
            }
            int index=word1.length()*2;
            for (int i =word1.length();i<word2.length();i++) {
                w3[index++] = word2.charAt(i);
            }
        } else {
            for (int i = 0;i<word2.length();i++) {
                w3[i*2] = word1.charAt(i);
                w3[i*2+1] = word2.charAt(i);
            }
            int index=word2.length()*2;
            for (int i =word2.length();i<word1.length();i++) {
                w3[index++] = word1.charAt(i);
            }
        }
        return new String(w3);
    }
}