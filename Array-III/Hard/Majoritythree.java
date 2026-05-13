class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //n/3 set it to count not neccessary though
        int count = nums.length/3;
        //frequency map
        HashMap<Integer, Integer> map = new HashMap<>();
        //update frequencies
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        //final result
        List<Integer> li = new ArrayList<>();
        //iterate map to get results
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            //only 2 elements can occur more than n/3 times
            if(li.size()==2) return li;
            //add them to list
            if(entry.getValue()>count) li.add(entry.getKey());
        }
        return li;
    }
}
