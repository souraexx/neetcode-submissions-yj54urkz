class Solution {
    public String simplifyPath(String path) {
         Stack<String> stack = new Stack<>();
         StringBuilder current = new StringBuilder();
         for (int i=0; i<path.length(); i++) {
            char ch = path.charAt(i);
            if (ch=='/') {
                if (current.length()>0) {
                    String currentPath = current.toString();
                    if (currentPath.equals("..")) {
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }
                    } else if (!currentPath.equals(".")) {
                        stack.push(currentPath);
                    }
                    current.setLength(0);
                }
            } else {
                current.append(ch);
            }
         }

        if (current.length()>0) {
            String currentPath = current.toString();
            if (currentPath.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!currentPath.equals(".")) {
                stack.push(currentPath);
            }
            current.setLength(0);
        }

         return "/"+String.join("/",stack);
    }
}