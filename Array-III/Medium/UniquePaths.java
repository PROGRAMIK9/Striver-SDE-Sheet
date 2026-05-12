class Solution {
    public int uniquePaths(int m, int n) {
        // //Bottom up
        // int[][] dp = new int[m][n];
        // //Set the entire last row to 1
        // for(int i = 0; i < m; i++){
        //     dp[i][n-1] = 1;
        // }
        // //Set the last column to 1
        // for(int j = 0; j<n; j++){
        //     dp[m-1][j] = 1;
        // }
        // //calculate the path backwards by adding the immediate right and bottom values
        // for(int i = m-2; i >= 0; i--){
        //     for(int j = n-2; j>=0; j--){
        //         dp[i][j] = dp[i+1][j] + dp[i][j+1];
        //     }
        // }
        // //return first location
        // return dp[0][0];
        //Top down
        int[][] dp = new int[m][n];
        //Set the first row to 1
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        //Set the first column to 1
        for(int j = 0; j<n; j++){
            dp[0][j] = 1;
        }
        //calculate the path backwards by adding the immediate left and top values
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        //return goal location
        return dp[m-1][n-1];
    }
}
