class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        boolean[] cols = new boolean[n];
        boolean[] pdiag = new boolean[2*n];
        boolean[] ndiag = new boolean[2*n];

        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }

        backtrack(0, n, board, cols, pdiag, ndiag, res);
        return res;
    }

    private void backtrack(int row, int n, char[][] board, boolean[] cols, boolean[] pdiag, boolean[] ndiag, List<List<String>> res){
        if(row == n){
            res.add(constructBoard(board));
            return;
        }
        for(int col = 0; col < n; col++){
            int pidx = row+col;
            int nidx = row-col+n;
            if(cols[col] || pdiag[pidx] || ndiag[nidx]){
                continue;
            }
            board[row][col]='Q';
            cols[col] = true; pdiag[pidx] = true; ndiag[nidx] = true;
            backtrack(row+1, n, board, cols, pdiag, ndiag, res);
            board[row][col] = '.';
            cols[col] = false; pdiag[pidx] = false; ndiag[nidx] = false;
        }
    }

    private List<String> constructBoard(char[][] board){
        List<String> curr = new ArrayList<>();
        for(int i = 0;i < board.length;i++){
            curr.add(new String(board[i]));
        }
        return curr;
    }
}
