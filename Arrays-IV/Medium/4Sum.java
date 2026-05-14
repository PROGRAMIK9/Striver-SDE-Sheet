class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //sort the array
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        //fix the first element
        for(int i=0; i<n; i++) {
            //if its the same number as last one skip it
            if(i > 0 && nums[i] == nums[i-1]) continue;
            //fix 2nd number
            for(int j=i+1; j<n; j++) {
                //if its same as last number skip it
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                //fix 3rd and 4th number
                int k = j + 1;
                int l = n - 1;
                //iterate the remaining elements
                while(k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    //check for sum
                    if(sum < target) k++;
                    else if(sum > target) l--;
                    else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++; l--;
                        while(k < l && nums[k] == nums[k-1]) k++;
                        while(k < l && nums[l] == nums[l+1]) l--;
                    }
                }
            }
        }

        return result;
    }
}
