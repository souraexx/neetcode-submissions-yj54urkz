class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> checkSet = new HashSet<>();
        int length = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            while(!checkSet.add(ch)) {
                checkSet.remove(s.charAt(left));
                left++;
            }
            length = Math.max(length, i-left+1);
        }
        return length;
    }
}
