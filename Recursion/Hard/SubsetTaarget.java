class Solution {
    Boolean[][] memo;
    public boolean isSubsetSum(int[] arr, int target) {
      memo = new Boolean[arr.length][target+1];
      return solve(0,arr,target);
    }
    private boolean solve(int index, int[] arr, int target){
        if(target == 0) return true;
        if(index ==  arr.length || target < 0) return false;
        if(memo[index][target]!=null) return memo[index][target];
        boolean skip = solve(index+1, arr, target);
        boolean pick = false;
        if(target>=arr[index]){
            pick = solve(index+1, arr, target-arr[index]);
        }
        return memo[index][target] = pick||skip;
    } 
}
