class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> validCheck = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i<m ;i++) {
            for (int j =0; j<n;j++) {
                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    String row = board[i][j] + " is at row " + i;
                    String column = board[i][j] + " is at column "+j;
                    String grid = board[i][j] + " is at grid " + i/3 +"-"+j/3;
                    if (!validCheck.add(row) || !validCheck.add(column) || !validCheck.add(grid)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
