class Solution {
    // Arrays of bitmasks to track numbers 1-9 used in rows, cols, and boxes
    private int[] rows = new int[9];
    private int[] cols = new int[9];
    private int[] boxes = new int[9];

    public void solveSudoku(char[][] board) {
        // Step 1: Pre-populate our bitmasks with the numbers already on the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1'; // Map '1'-'9' to 0-8
                    int mask = 1 << num;
                    int boxIdx = (i / 3) * 3 + (j / 3);
                    
                    rows[i] |= mask;
                    cols[j] |= mask;
                    boxes[boxIdx] |= mask;
                }
            }
        }
        
        // Step 2: Start backtracking
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int row, int col) {
        // If we reach column 9, move to the next row
        if (col == 9) {
            row++;
            col = 0;
        }
        // If we reach row 9, the entire board is successfully filled!
        if (row == 9) {
            return true; 
        }

        // If the current cell is already filled, move to the next cell
        if (board[row][col] != '.') {
            return backtrack(board, row, col + 1);
        }

        int boxIdx = (row / 3) * 3 + (col / 3);

        // Try placing numbers 1 through 9
        for (int num = 0; num < 9; num++) {
            int mask = 1 << num;

            // O(1) Validation check using bitwise AND
            if ((rows[row] & mask) == 0 && (cols[col] & mask) == 0 && (boxes[boxIdx] & mask) == 0) {
                
                // Set state
                board[row][col] = (char) ('1' + num);
                rows[row] |= mask;
                cols[col] |= mask;
                boxes[boxIdx] |= mask;

                // Move to the next cell. If it returns true, pass it up!
                if (backtrack(board, row, col + 1)) {
                    return true;
                }

                // Backtrack / Undo state
                board[row][col] = '.';
                rows[row] &= ~mask;
                cols[col] &= ~mask;
                boxes[boxIdx] &= ~mask;
            }
        }

        return false; // Trigger backtracking if no number 1-9 fits here
    }
}
