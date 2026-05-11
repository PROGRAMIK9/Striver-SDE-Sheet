class Solution {
    public int findDuplicate(int[] nums) {
        //with extra space
        // int[] content = new int[nums.length];
        // for(int i = 0;i<nums.length;i++){
        //     if(content[nums[i]]!=0) return nums[i];
        //     content[nums[i]] = nums[i];
        // }
        // return -1;
        //without extra space
        //fast and slow pointer
        int slow = 0;
        int fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);

        slow = 0;
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
