class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int max = 0;
        int[] res = new int[nums.length-k+1];
        for (int i = 0; i < nums.length; i++) {
            // 1. Remove indices that are out of the current window's bounds
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            
            // 2. Remove elements from the back that are smaller than the current element.
            // They are useless because the current element is larger AND will stay in the window longer.
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            // 3. Add the current element's index to the back of the deque
            deque.offerLast(i);
            
            // 4. Once we have processed at least 'k' elements, the maximum for the 
            // current window is always at the very front of the deque.
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return res;
    }

    private int findMax(int[] nums, int i, int k){
        int max  = Integer.MIN_VALUE;
        for(int j = i;j<=k;j++){
            max = Math.max(nums[j], max);
        }
        return max;
    }
}
