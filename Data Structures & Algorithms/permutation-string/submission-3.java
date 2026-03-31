class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char s1Array[] = s1.toCharArray();
        Arrays.sort(s1Array);
        String sortedS1 = new String(s1Array);

        int left = 0;
        int right = sortedS1.length();

        while (right <= s2.length()) {
            String temp = s2.substring(left, right);
            char tempArray[] = temp.toCharArray();
            Arrays.sort(tempArray);
            String sortedTemp = new String(tempArray);
            if (sortedTemp.equals(sortedS1)) {
                return true;
            } else {
                left++;
                right++;
            }
        }

        return false;
    }
}
