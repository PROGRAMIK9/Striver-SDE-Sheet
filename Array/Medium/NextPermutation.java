class Solution {
    public void nextPermutation(int[] nums) {
        // find the index of the first number lesser than itss immediate next number
        int i1 = -1;
        //Iterate to find that number
        for(int j=nums.length-1;j>0;j--){
            //store the index if condition is true
            if(nums[j]>nums[j-1]){
                i1 = j-1;
                break;
            }
        }
        // if no such element reverse the whole array a that is the largest number
        if(i1==-1){
            reverse(nums,0,nums.length-1);
            return;
        }
        // find the smallest number larger than nums[i1]
        for(int i= nums.length-1;i>=0;i--){
            //swap them
            if(nums[i]>nums[i1]){
                swap(nums,i,i1);
                break;
            }
        }
        //reversse the rest of the array
        reverse(nums,i1+1,nums.length-1);
    }
    //function to reverse an array from index i to j
    public void reverse(int[] arr, int i, int j){
        while(i<j){
            swap(arr,i,j);
            i++;
            j--;
        }
    }
    //function to swap element at index i and j
    public void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
