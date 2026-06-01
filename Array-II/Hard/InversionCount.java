class Solution {
    public long merge(int[] nums, int l, int r){
        long count = 0;
        if(l>=r)return count;
        int mid = l+(r-l)/2;
        count+=merge(nums,l,mid);
        count+=merge(nums, mid+1, r);
        count+=mergeSort(nums,l,mid,r);
        return count;
    }
    public long mergeSort(int[] nums, int l, int mid, int r){
        int[] temp = new int[r-l+1];
        int i = l, j = mid+1, k=0;
        long count = 0;
        while(i<=mid && j<=r){
            if(nums[i]<=nums[j]){
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
                count+=(mid-i+1);
            }
        }
        while(i<=mid){
            temp[k++] = nums[i++];
        }
        while(j<=r){
            temp[k++] = nums[j++];
        }
        for(i = l, k=0; i<=r;i++,k++){
            nums[i++] = temp[k++];
        }
        return count;
    }
    public long numberOfInversions(int[] nums) {
        return merge(nums,0,nums.length-1);
    }
}
