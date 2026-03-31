class Solution {
    public String minWindow(String s, String t) {

       int m = t.length();
       int n = s.length();
       int count = 0;
       int startIndex = -1;
       int minWindow = 1001; 
       Map<Character, Integer> checkFreq = new HashMap<>();

       for (int i = 0; i<m; i++) {
        char ch = t.charAt(i);
        if (checkFreq.containsKey(ch)) {
            checkFreq.put(ch, checkFreq.get(ch)+1);
        } else {
            checkFreq.put(ch, 1);
        }
       } 

       int left = 0;
       int right =0;
       Map<Character, Integer> windowFreq = new HashMap<>();

       while (right < n) {

        char ch = s.charAt(right);
        windowFreq.put(ch, windowFreq.getOrDefault(ch, 0)+1);
        if (checkFreq.containsKey(ch) && checkFreq.get(ch)==windowFreq.get(ch)) {
            count++;
        }

        while (count == checkFreq.size()) {
            
            if (right - left + 1 < minWindow) {
                minWindow = right - left + 1;
                startIndex = left;
            }
            char chLeft = s.charAt(left);
            windowFreq.put(chLeft, windowFreq.get(chLeft)-1);
            if (checkFreq.containsKey(chLeft) && checkFreq.get(chLeft) > windowFreq.get(chLeft)) {
                count--;
            }
            left++;
        }
        right ++;
       }

        if (startIndex == -1) {
            return "";
        } else {
            return s.substring(startIndex, startIndex + minWindow);
        }
    }
}
