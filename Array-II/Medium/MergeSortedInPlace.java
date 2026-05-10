class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //Track last of each array
        int last = n+m-1;
        int i = m-1;
        int j = n-1;
        //go down all the way for both
        while(i>=0 && j>=0){
            //if nums2 is greated add to end
            if(nums2[j] > nums1[i]){
                nums1[last--] = nums2[j--];
            }
            //else add nums1
            else{
                nums1[last--] = nums1[i--];
            }
        }
        //incase nums1 is done
        while(j>=0){
            nums1[last--] = nums2[j--];
        }
    }
}
