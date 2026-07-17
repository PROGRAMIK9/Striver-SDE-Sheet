class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if(m < n) return longestCommonSubsequence(text2, text1);
        // int dp[][] = new int[m+1][n+1];
        // // for(int i = 0;i<m;i++){
        // //     dp[i][n] = 0;
        // // }
        // // for(int j = 0; j<n;j++){
        // //     dp[m][j] = 0;
        // // }
        // for(int i =1;i<=m;i++){
        //     for(int j = 1; j<=n;j++){
        //         if(text1.charAt(i-1) ==  text2.charAt(j-1)){
        //             dp[i][j] = 1 + dp[i-1][j-1];
        //         }else{
        //             dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
        //         }
        //     }
        // }
        // return dp[m][n];    
        int prev[] =  new int[n+1];
        int curr[] =  new int[n+1];
        for(int i = 1; i<=m;i++){
            for(int j  =1; j<=n;j++){
                if(text1.charAt(i-1) ==  text2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }else{
                    curr[j] = Math.max(curr[j-1], prev[j]);
                }
            }
            prev = curr.clone();
        }
        return prev[n];

    }
}
