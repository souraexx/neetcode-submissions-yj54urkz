class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for(String word : strs) {
            int len = word.length();
            encodedString = encodedString.append(len).append("#").append(word);

        }
        String result = encodedString.toString().trim();
        System.out.println(result);
        return result;
    }

    public List<String> decode(String str) {
        List<String> decodedString = new ArrayList();
        char[] charArray = str.toCharArray();
        for(int i=0; i<charArray.length;) {
            int len = 0;
            int j = i;
            while (charArray[j]!='#') {
                len = len * 10 + (charArray[j]-'0');
                j++;
                i++;
            }
            String word = str.substring(i+1,i+1+len);
            decodedString.add(word);
            i = i+1+len;
        }
        return decodedString;
    }
}
