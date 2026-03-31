class Solution {
    public boolean isValid(String s) {
        Stack<Character> validCheck = new Stack<>();
        for (int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch =='(' || ch == '{' || ch == '[') {
                validCheck.push(ch);
            } else {
                if (validCheck.isEmpty()) {
                    return false;
                }

                char top = validCheck.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                        return false;
                    }

            }
        }
        return validCheck.isEmpty();
    }
}
