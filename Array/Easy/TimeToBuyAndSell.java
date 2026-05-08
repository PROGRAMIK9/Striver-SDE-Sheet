class Solution {
    public int maxProfit(int[] prices) {
        //set buy price to day 1's price
        int buy = prices[0];
        //set the inital profit to 0
        int profit = 0;
        //loop through the other days prices
        for(int i = 1;i < prices.length; i++){
            //updte buy to minimum
            if(prices[i] < buy){
                buy = prices[i];
            }
            //update profit to maximum
            profit = Math.max(profit, prices[i]-buy);
        }
        return profit;
    }
}
