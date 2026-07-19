class Solution {
    public List<Integer> subsetSums(int[] nums) {
        //your code goes here
        List<Integer> list = new ArrayList<>();
        findSum(0,0,nums,list);
        Collections.sort(list);
        return list;
    }
    private void findSum(int index, int sum, int[] nums, List<Integer> sums){
        if(index ==  nums.length){
            sums.add(sum);
            return;
        }
        findSum(index+1, sum+ nums[index], nums, sums);
        findSum(index+1, sum, nums, sums);
    }
}
