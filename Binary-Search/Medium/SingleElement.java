class Solution {
    public int singleNonDuplicate(int[] nums) {
        int i = 0, j = nums.length-1;
        while(i < j){
            int mid = i + (j-i)/2;
            if( (mid % 2 == 0 && nums[mid] == nums[mid+1]) || (mid % 2 == 1 && nums[mid] == nums[mid-1])){
                i = mid + 1;
            }else{
                j = mid;
            }
        }
        return nums[i];
    }
}
