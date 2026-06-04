class Solution {
    public int trap(int[] height) {
        //Length of the array
        int n = height.length;
        //Store the total Water trapped
        int totalWater = 0;
        int start = 0;//two pointer approach
        int end = n-1;
        int leftMax = 0;//Local left max
        int rightMax = 0;//local right max
        while(start<end){
            //update left and right max at each iteration
            leftMax = Math.max(leftMax, height[start]);
            rightMax = Math.max(rightMax, height[end]);
            //if the left is lesser then we can store the left side
            if(leftMax < rightMax){
                totalWater += leftMax - height[start];
                start++;
            }
            //If the right side is lesser then trap it there 
            else{
                totalWater += rightMax - height[end];
                end--;
            }
        }
        return totalWater;
    }
}
