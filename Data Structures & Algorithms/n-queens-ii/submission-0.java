class Solution {
    public int totalNQueens(int n) {
      String[][]  board = new String[n][n];
      for (int i = 0; i<n; i++) {
        for(int j=0; j<n; j++) {
            board[i][j] = ".";
        }
      }
      int count = 0;
      HashSet<Integer> left = new HashSet<>(); // col
      HashSet<Integer> upDiag = new HashSet<>(); // row - col
      HashSet<Integer> downDiag = new HashSet<>(); // row + col
      count = getQueens(board, left, upDiag, downDiag, 0);
      return count;
    }
    private int getQueens(String[][] board, HashSet<Integer> left,
     HashSet<Integer> upDiag, HashSet<Integer> downDiag, int row) {
        if (row == board.length) {
            return 1;
        }
        int count = 0;
        for (int col=0; col<board[0].length; col++) {
            if (left.contains(col) || upDiag.contains(row-col) || downDiag.contains(row+col))
                continue;
            
            //pick
            left.add(col);
            upDiag.add(row-col);
            downDiag.add(row+col);
            board[row][col] = "Q";

            count += getQueens(board, left, upDiag, downDiag, row+1);

            // not pick
            left.remove(col);
            upDiag.remove(row-col);
            downDiag.remove(row+col);
            board[row][col] = ".";
        }
        return count;
     }

}