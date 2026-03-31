class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Hash[] = new int[26];
        int s2Hash[] = new int[26];

        for (int i = 0; i<s1.length();i++) {
            int chS1 = s1.charAt(i) - 'a';
            s1Hash[chS1]++;

            if (s2.length()-1 >= i) {
                int chS2 = s2.charAt(i) - 'a';
                s2Hash[chS2]++;
            }
        }

        if (Arrays.equals(s1Hash, s2Hash)) {
            return true;
        }

        int left = 0;
        for (int right = s1.length(); right<s2.length(); right++) {
            int chRight = s2.charAt(right) - 'a';
            s2Hash[chRight]++;
            int chLeft = s2.charAt(left) - 'a';
            s2Hash[chLeft]--;
            if (Arrays.equals(s1Hash, s2Hash)) {
                return true;
            }
            left++;
        }

        return false;
    }
}
