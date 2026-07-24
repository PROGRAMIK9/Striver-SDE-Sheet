class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int coin:coins){
            for(int i = amount; i>=coin;i--){
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        return dp[amount] == amount+1?0:dp[amount];
    }
}
