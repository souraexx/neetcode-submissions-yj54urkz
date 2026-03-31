class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        String prefix = strs[0];
        for(int i = 1; i<strs.length;i++) {
            prefix = commonPrefix(prefix, strs[i]);
            if (prefix.length() == 0)
                break;
        }
        return prefix;
    }
    private String commonPrefix(String prefix, String check) {
        int size = Math.min(prefix.length(), check.length());
        int i;
        for (i = 0; i<size;i++) {
            if (prefix.charAt(i) != check.charAt(i)) {
                break;
            }
        }
        return prefix.substring(0,i);
    }
}