class Solution {
    public int removeDuplicates(int[] nums) {
        // int n = nums.length;
        // Set<Integer> set = new LinkedHashSet<>();
        // for(int i = 0;i<n;i++){
        //     set.add(nums[i]);
        // }
        // int i=0;
        // for(int num:set){
        //     nums[i++]=num;
        // }
        // return set.size();
        // If array is empty, return 0
        if (nums.length == 0) return 0;

        // Pointer for last unique element
        int i = 0;

        // Start from second element
        for (int j = 1; j < nums.length; j++) {
            // If new unique element is found
            if (nums[j] != nums[i]) {
                // Move unique position forward
                i++;
                // Place new unique element
                nums[i] = nums[j];
            }
        }

        // i is last index of unique element, count = i + 1
        return i + 1;
    }
}
