class Solution {
    private void dfs(char[][] board, int[][] visited, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        if (i>=m || j>=n || i<0 || j<0 || visited[i][j]==1 || board[i][j]!='O') {
            return;
        }
        visited[i][j] = 1;
        dfs(board, visited, i+1, j);
        dfs(board, visited, i-1, j);
        dfs(board, visited, i, j+1);
        dfs(board, visited, i, j-1);
    }
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int visited[][] = new int[rows][cols];
        for (int i=0;i<rows;i++) {
            // left column
            if (board[i][0]=='O' && visited[i][0]==0) {
                dfs(board, visited, i, 0);
            }
            // right column 
            if (board[i][cols-1]=='O' && visited[i][cols-1]==0) {
                dfs(board, visited, i, cols-1);
            }
        }
        for (int j=0;j<cols;j++) {
            // top row
            if (board[0][j]=='O' && visited[0][j]==0) {
                dfs(board, visited, 0, j);
            }
            // bottom row
            if (board[rows-1][j]=='O' && visited[rows-1][j]==0) {
                dfs(board, visited, rows-1, j);
            }
        }

        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if (board[i][j]=='O' && visited[i][j]==0) {
                    board[i][j]= 'X';
                }
            }
        }
    }
}
