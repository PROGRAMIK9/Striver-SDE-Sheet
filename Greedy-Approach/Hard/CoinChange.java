class Solution {
    public int coinChange(int[] coins, int amount) {
        // Create an array to store the minimum coins for each amount from 0 to 'amount'
        int[] dp = new int[amount + 1];
        
        // Fill the array with a value larger than any possible answer (amount + 1 is safe)
        int max = amount + 1;
        Arrays.fill(dp, max);
        
        // Base case: 0 coins are needed to make amount 0
        dp[0] = 0;
        
        // Build the dp array from bottom up
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    // Choose the minimum between keeping the current best, 
                    // or using this 'coin' and taking the best result for the remainder
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // If the final amount is still greater than our possible max, it's impossible
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
