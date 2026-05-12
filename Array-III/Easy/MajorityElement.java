class Solution {
    public int majorityElement(int[] nums) {
        // //Brute force
        // int n = nums.length;
        // //Frequency Map
        // HashMap<Integer, Integer> count = new HashMap<>();
        // //Update The count map
        // for(int num: nums){
        //     count.put(num, count.getOrDefault(num,0)+1);
        // }
        // //check if any element has count > n/2
        // for(Map.Entry<Integer, Integer> entry : count.entrySet()){
        //     if(entry.getValue()>n/2) return entry.getKey();
        // }
        // return nums[0];
        //Optimal
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
