class Solution {
    public void subDupe(int nums[], int ind, List<List<Integer>> list, List<Integer> curr){
        // if(ind == nums.length){
        //     list.add(new ArrayList<>(curr));
        //     return;
        // }
        // curr.add(nums[ind]);
        // subDupe(nums, ind+1, list, curr);
        // curr.remove(curr.size()-1);
        // subDupe(nums, ind+1, list, curr);
        list.add(new ArrayList<>(curr));
         for (int i = ind; i < nums.length; i++) {
            // Skip duplicates
            if (i > ind && nums[i] == nums[i - 1]) continue;

            // Include nums[i] in current subset
            curr.add(nums[i]);

            // Recurse for next index
            subDupe(nums, i+1, list, curr);

            // Backtrack: remove last element
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Set<List<Integer>> list = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        subDupe(nums, 0, list, new ArrayList<>());
        return new ArrayList<>(list);
    }
}
