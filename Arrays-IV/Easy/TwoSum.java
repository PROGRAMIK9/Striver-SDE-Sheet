class Solution {
    public int[] twoSum(int[] nums, int target) {
        // //Brute force
        //Just sum each element with every element except itself if match just return
        // for(int i = 0;i<nums.length; i++){
        //     for(int j = i+1; j< nums.length; j++){
        //         if(nums[i]+nums[j] == target){
        //             return new int[]{i,j};
        //         }
        //     }
        // }
        // return new int[]{};
        //Sorting and 2 pointer wont work due to index requirement
        // Arrays.sort(nums);
        // int i = 0, j =  nums.length-1;
        // while(i<j){
        //     if(nums[i]+nums[j] == target) return new int[]{i,j};
        //     else if(nums[i]+nums[j] < target) i++;
        //     else j--;
        // }
        // return new int[]{};
        //HashMaps
        HashMap<Integer, Integer> map = new HashMap<>();
        //iterate through nums 
        for(int i = 0;i<nums.length;i++){
            //check if nums[i] is the value required for any value
            if(map.containsKey(nums[i])){ 
                return new int[]{map.get(nums[i]),i};
            }
            //if not then add target-nums[i](required value) with the index of the value as map value
            map.put(target-nums[i], i);
        }
        return new int[]{};
    }
}
