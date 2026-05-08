class Solution {
    public void sortColors(int[] nums) {
        //3 pointers for 0, 1, 2
        int low = 0, mid = 0, high = nums.length-1;
        //stop when mid > high
        while(mid<=high){
          //if zero swap with low
          if(nums[mid] == 0){
            swap(nums, mid ,low);
            mid++;
            low++;
          }
          //if 1 continue
          else if(nums[mid] == 1){
            mid++;
          }
          //if 2 swap with high
          else{
            swap(nums, mid, high);
            high--;
          }
        }
    }
    //swap function to swap 2 numbers
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
