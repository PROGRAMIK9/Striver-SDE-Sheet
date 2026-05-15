class Solution {
    public int longestConsecutive(int[] nums) {
        // //The length of nums
        // int n  = nums.length;
        // //if length is 0 no possibility
        // if(n==0) return 0;
        // //sort the array
        // Arrays.sort(nums);
        // int cur = 1;
        // int max = 0;
        // //find the maximum sequence
        // for(int i=1; i<n ; i++){
        //     //only if the the numbers arent the same
        //     if(nums[i]!=nums[i-1]){
        //         //check if its the next number
        //         if(nums[i]==nums[i-1]+1){
        //             cur++;
        //         }else{
        //             max = Math.max(max,cur);
        //             cur=1;
        //         }
        //     }
        // }
        // return Math.max(max,cur);
        int n = nums.length;

        // If the array is empty, no sequence exists
        if (n == 0) return 0;

        // Variable to store the longest sequence length found
        int longest = 1; 

        // HashSet to store unique elements for O(1) lookup
        Set<Integer> st = new HashSet<>();

        // Add all elements to the set to remove duplicates
        for (int i = 0; i < n; i++) {
            st.add(nums[i]);
        }

        /* Loop through each element in the set to find 
           the starting point of consecutive sequences */
        for (int it : st) {
            // If there is no number before 'it', it’s the start of a sequence
            if (!st.contains(it - 1)) {
                // Start the count for this sequence
                int cnt = 1; 
                // Store the current number
                int x = it; 

                // Keep checking for the next consecutive number
                while (st.contains(x + 1)) {
                    // Move to the next number in sequence
                    x = x + 1; 
                    // Increment the length of current sequence
                    cnt = cnt + 1; 
                }

                // Update the longest sequence length if needed
                longest = Math.max(longest, cnt);
            }
        }

        // Return the length of the longest sequence
        return longest;
    }
}
