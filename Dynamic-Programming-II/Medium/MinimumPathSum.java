class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 0; i<m ;i++){
            for(int j = 0; j<n; j++){
                if(i ==0 && j == 0) continue;
                int up = i > 0 ? grid[i][j] + dp[i-1][j] : Integer.MAX_VALUE;
                int left = j > 0 ? grid[i][j] + dp[i][j-1] : Integer.MAX_VALUE;
                dp[i][j] = Math.min(up,left);
            }
        }
        return dp[m-1][n-1];
    }
}
// class Solution {
//     private int m;
//     private int n;
//     private int[][] dp;

//     public int minPathSum(int[][] grid) {
//         m = grid.length;
//         n = grid[0].length;

//         dp = new int[m][n];
//         dp[0][0] = grid[0][0];

//         for(int i = 1; i < m; i++)
//         {
//             dp[i][0] = dp[i-1][0] + grid[i][0];
//         }

//         for(int j = 1; j < n; j++)
//         {
//             dp[0][j] = dp[0][j-1] + grid[0][j];
//         }

//         rec(1, m, n, grid);
//         return dp[m-1][n-1];
//     }

//     void rec(int i, int m, int n,int[][] grid){
//         if(i==m) return;
//         for(int j=1;j<n;j++)
//             dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
//         rec(i+1,m,n,grid);
//     }
// }
