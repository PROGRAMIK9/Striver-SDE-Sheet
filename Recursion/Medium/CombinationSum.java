class Solution {
    public void backtrack(int ind, int[] nums, int target, List<List<Integer>> list, List<Integer> curr){
        if(ind == nums.length){
            if(target == 0){
                list.add(new ArrayList<>(curr));
            }
            return;
        }
        if (nums[ind] <= target) {
            curr.add(nums[ind]);  // Add the current element to the combination
            backtrack(ind, nums, target-nums[ind], list, curr);  // Continue with the same index to allow repeated elements
            curr.remove(curr.size() - 1);  // Backtrack by removing the last added element
        }

        // Skip the current element and move to the next index
        backtrack(ind + 1, nums, target, list, curr);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(0, candidates, target, list, new ArrayList<>());
        return list;
    }
}
