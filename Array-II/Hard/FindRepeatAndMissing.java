class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        
        int n = nums.length;
        int osum = (n*(n+1))/2, ssum = (n*(n+1)*(2*n+1))/6;
        int sum = 0, sumsq = 0;
        for(int i = 0;i<n;i++){
            sum += nums[i];
            sumsq += nums[i]*nums[i];
        }
        int val1 = sum - osum;
        int val2 = sumsq - ssum;
        val2 = val2/val1;
        int repeat = (val1+val2)/2;
        int miss =  repeat-val1;
        return new int[]{repeat, miss};
    }
}
