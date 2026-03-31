class Solution {
    public boolean isAnagram(String s, String t) {
        int arrS[] = new int[26];
        int arrT[] = new int[26];

        for (char ch : s.toCharArray()) {
            arrS[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            arrT[ch - 'a']++;
        }

        for (int i = 0; i<26; i++) {
            if (arrS[i]!= arrT[i])
                return false;
        }

        return true;
    }
}
