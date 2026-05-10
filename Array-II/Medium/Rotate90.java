class Solution {
    public void rotate(int[][] matrix) {
        // int n = matrix.length;
        // //Create A new matrix
        // int[][] res =  new int[n][n];
        // //loop the matrix
        // for(int i = 0;i<n;i++){
        //     for(int j = 0; j<n;j++){
        //         //store ijth element in res ta the jth row and n-i-1th column
        //         res[j][n-i-1] = matrix[i][j];
        //     }
        // }
        // for(int i = 0;i<n;i++){
        //     for(int j = 0; j<n;j++){
        //         //copy res onto matrix
        //         matrix[i][j] = res[i][j];
        //     }
        // }
        int n = matrix.length;
        //Transpose The matrix
        for(int i = 0;i < n; i++){
            for(int j = i+1; j < n; j++){
                // Swap i,j with j,i
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;

            // Swap elements from both ends moving toward center
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
