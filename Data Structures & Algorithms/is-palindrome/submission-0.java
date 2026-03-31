class Solution {
    public boolean isPalindrome(String s) {
         StringBuilder pali = new StringBuilder();
         for (int i = 0;i <s.length();i++) {
            int ch = (int)s.charAt(i);
            if (((ch>=65)&&(ch<=90)) || ((ch>=96)&&(ch<=122)) || ((ch>=48)&&(ch<=57))) {
                pali.append(s.charAt(i));
            }
         }
         String lowerS = pali.toString().trim().toLowerCase();
         int start = 0;
         int end = lowerS.length()-1;
         while(start <= end) {
            char startChar = lowerS.charAt(start);
            char endChar = lowerS.charAt(end);
            if (startChar == ' ')
                start++;
            else if (endChar == ' ')
                end--;
            else if (startChar != endChar) 
                return false;
            else if (startChar == endChar) {
                start++;
                end--;
            }
         }
         return true;
    }
}
