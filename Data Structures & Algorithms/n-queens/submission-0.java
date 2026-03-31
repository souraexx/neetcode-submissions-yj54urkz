class Solution {
    public List<List<String>> solveNQueens(int n) {
      String[][]  board = new String[n][n];
      for (int i = 0; i<n; i++) {
        for(int j=0; j<n; j++) {
            board[i][j] = ".";
        }
      }
      List<List<String>> result = new ArrayList<>();
      HashSet<Integer> left = new HashSet<>(); // col
      HashSet<Integer> upDiag = new HashSet<>(); // row - col
      HashSet<Integer> downDiag = new HashSet<>(); // row + col
      getQueens(board, left, upDiag, downDiag, 0, result);
      return result;
    }
    private void getQueens(String[][] board, HashSet<Integer> left,
     HashSet<Integer> upDiag, HashSet<Integer> downDiag, int row, List<List<String>> result) {
        if (row == board.length) {
            result.add(construct(board));
            return;
        }
        for (int col=0; col<board[0].length; col++) {
            if (left.contains(col) || upDiag.contains(row-col) || downDiag.contains(row+col))
                continue;
            
            //pick
            left.add(col);
            upDiag.add(row-col);
            downDiag.add(row+col);
            board[row][col] = "Q";

            getQueens(board, left, upDiag, downDiag, row+1, result);

            // not pick
            left.remove(col);
            upDiag.remove(row-col);
            downDiag.remove(row+col);
            board[row][col] = ".";
        }
     }
    private List<String> construct(String[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                sb.append(board[i][j]);
            }
            list.add(sb.toString());
        }
        return list;
    }

}
