class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        //store local count
        int count = 0;
        //store global count
        int maxCount = 0;
        //traverse nums
        for(int n:nums){
            //if n is 1
            if(n==1){
                //increment count
                count++;
                //set global max
                maxCount = Math.max(maxCount, count);
            }else{
                //if not 1 reset count
                count = 0;
            }
        }
        return maxCount;
    }
}
