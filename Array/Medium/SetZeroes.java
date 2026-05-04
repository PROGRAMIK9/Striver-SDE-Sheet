class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<int[]> zeroes = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroes.add(new int[] { i, j });
                }
            }
        }
        for (int[] z : zeroes) {
            int r = z[0];
            int c = z[1];
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][c] = 0;
            }
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[r][i] = 0;
            }
        }
    }
}
