class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        //iterate each row
        for(int i=0;i<n;i++){
            //check if target doesnt exists between the first and last element of this row
            if(matrix[i][0]>target || matrix[i][m-1] < target ){
                continue;
            }
            //if it does tun binary search on the row
            else{
                int start = 0;
                int end = m-1;
                while(start<=end){
                    int mid =(start+end)/2;
                    if(matrix[i][mid]==target)return true;
                    else if(matrix[i][mid]>target) end = mid-1;
                    else start = mid+1;
                }
            }
        }    
        //return false if its not found
        return false;
    }
}
