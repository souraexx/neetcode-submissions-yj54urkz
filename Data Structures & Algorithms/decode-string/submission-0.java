class Solution {
    public String decodeString(String s) {
       Stack<Integer> countStack = new Stack<>();
       Stack<String> charStack = new Stack<>();
       int currentCount = 0;
       StringBuilder currentString = new StringBuilder();
       for(int i=0; i<s.length(); i++) {
        char ch = s.charAt(i);
        if (isNumber(ch)) {
            currentCount = currentCount*10 + (ch-'0');
        } else if (ch == '[') {
            countStack.push(currentCount);
            charStack.push(currentString.toString());
            currentCount = 0;
            currentString.setLength(0);
        } else if (ch == ']') {
            int repeat = countStack.pop();
            StringBuilder previous = new StringBuilder(charStack.pop());
            for (int j=0;j<repeat;j++) {
                previous.append(currentString);
            }
            currentString = previous;
        } else {
            currentString.append(ch);
        }
       }
    return currentString.toString();
    }
    private Boolean isNumber(char ch) {
        int num = (int)ch;
        return ((num>=48) && (num<=57));
    }
}
//ab2[c]