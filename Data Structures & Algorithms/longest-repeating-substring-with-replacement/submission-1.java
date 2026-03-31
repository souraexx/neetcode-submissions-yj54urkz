class Solution {
    public int characterReplacement(String s, int k) {
        int length = 0;
        int freqArray[] = new int[26];
        int left = 0;
        int maxFreq = 0;
        for (int right = 0; right<s.length(); right++) {
            int ch = s.charAt(right) - 'A';
            freqArray[ch]++;
            maxFreq = Math.max(maxFreq, freqArray[ch]);

            while ((right - left + 1) - maxFreq > k) {
                freqArray[s.charAt(left)-'A']--;
                left++;
            }
            length = Math.max(length, right - left +1);
        }
        return length;
    }
}

