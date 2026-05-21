class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        //Brute force
        // Set<List<Integer>> list = new HashSet<>();
        // for(int i = 0;i<nums.length;i++){
        //     for(int j = i+1;j<nums.length; j++){
        //         for(int k =j+1;k<nums.length;k++){
        //             if(nums[i]+nums[j]+nums[k] == 0){
        //                 List<Integer> li = new ArrayList<>();
        //                 li.add(nums[i]);li.add(nums[j]);li.add(nums[k]);
        //                 Collections.sort(li);
        //                 list.add(li);
        //             }
        //         }
        //     }
        // }
        // return new ArrayList<>(list);
        // Sort the array
        Arrays.sort(arr);
        // Store final result
        List<List<Integer>> ans = new ArrayList<>();
        int n =arr.length;
        // First loop for first element
        for (int i = 0; i < n; i++) {
            // Skip duplicates for first element
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            // Two pointers
            int left = i + 1, right = n - 1;

            // Find pairs for current arr[i]
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0) {
                    ans.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                    right--;

                    // Skip duplicates for left
                    while (left < right && arr[left] == arr[left - 1]) left++;
                    // Skip duplicates for right
                    while (left < right && arr[right] == arr[right + 1]) right--;
                }
                else if (sum < 0) left++;
                else right--;
            }
        }
        return ans;
    }
}
