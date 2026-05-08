class Solution {
    public int maxSubArray(int[] nums) {
        // keep track of current maximum
        int curMax = 0,
        //keep track of global maximum 
        maxTillNow = Integer.MIN_VALUE;
        //Iterate through each element in the array
        for(int c:nums){
            //set current maximum to the max of current element or the sum including current element
            curMax = Math.max(c, curMax+c);
            //Update global maximum
            maxTillNow = Math.max(maxTillNow, curMax);
        }
        return maxTillNow;
    }
}
