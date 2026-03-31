class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
       List<String> result = new ArrayList<>();
       getWord(s, wordDict, 0, new StringBuilder(), result);
       return result; 
    }
    private void getWord(String s, List<String> wordDict, int index, StringBuilder sb, List<String> result) {
        if (index == s.length()) {
            result.add(sb.toString());
            return;
        }
        for (int i=index;i<s.length();i++) {
            String temp = s.substring(index, i+1);
            if (wordDict.contains(temp)) {

                int len = sb.length();

                sb.append(temp);
                if (i != s.length()-1) {
                    sb.append(" ");
                } 

                getWord(s, wordDict, i+1, sb, result);

                sb.setLength(len);
            }
        }
    }
}  