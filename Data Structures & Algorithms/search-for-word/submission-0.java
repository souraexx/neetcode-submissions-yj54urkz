class Solution {
    public boolean exist(char[][] board, String word) {
        char ch = word.charAt(0);
        for (int i = 0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i<0 || j<0 || i>=board.length 
        || j>=board[0].length || (word.charAt(index)!=board[i][j])) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#'; // marked

        if (dfs(board, word, i+1, j, index+1) || dfs(board, word, i-1, j, index+1)
        || dfs(board, word, i, j+1, index+1) || dfs(board, word, i, j-1, index+1)) {
            return true;
        }

        board[i][j] = temp; // unmark

        return false;

    }
}
