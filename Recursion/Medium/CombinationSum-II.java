class Solution {
    public void backtrack(int ind, int[] arr, int target, List<List<Integer>> list, List<Integer> curr){
        if(target == 0){
            list.add(new ArrayList<>(curr));
            return;
        }
        // Loop through the elements starting from index 'ind'
        for (int i = ind; i < arr.length; i++) {
            // Skip duplicates to avoid repeating combinations
            if (i > ind && arr[i] == arr[i - 1]) continue;

            // If the current element is greater than the remaining target, break the loop
            if (arr[i] > target) break;

            // Include the current element in the combination
            curr.add(arr[i]);

            // Recur with the updated target and next index (i + 1 to avoid repetition)
            backtrack(i + 1, arr, target - arr[i], list, curr);

            // Backtrack by removing the last added element
            curr.remove(curr.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        backtrack(0, candidates, target, list, new ArrayList<>());
        return list;
    }
}
