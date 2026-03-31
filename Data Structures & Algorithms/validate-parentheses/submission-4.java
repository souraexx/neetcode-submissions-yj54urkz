class Solution {
    public boolean isValid(String s) {
        Stack<Character> validCheck = new Stack<>();
        for (int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                if (validCheck.isEmpty()) {
                    return false;
                }
                char top = validCheck.pop();
                if (top != '(') {
                    return false;
                }
            } else if (ch == '}') {
                if (validCheck.isEmpty()) {
                    return false;
                }
                char top = validCheck.pop();
                if (top != '{') {
                    return false;
                }
            } else if (ch == ']') {
                if (validCheck.isEmpty()) {
                    return false;
                }
                char top = validCheck.pop();
                if (top != '[') {
                    return false;
                }
            } else {
                validCheck.push(ch);
            }
        }
        if (validCheck.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
