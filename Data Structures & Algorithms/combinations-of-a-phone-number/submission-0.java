class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.equals("")) {
            return result;
        }

        String[] map = {"", "", "abc", "def", "ghi", 
        "jkl", "mno", "pqrs", "tuv", "wxyz"}; 

        getComb(digits, result, map, 0, new StringBuilder());
        return result; 
    }
    private void getComb(String digits, List<String> result, String[] map, int index, StringBuilder sb) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String temp = map[digits.charAt(index)-'0'];
        
        for (int i=0; i<temp.length(); i++) {
            sb.append(temp.charAt(i)); // pick
            getComb(digits, result, map, index+1, sb);
            sb.deleteCharAt(sb.length()-1); // not pick
        }

    }
}
