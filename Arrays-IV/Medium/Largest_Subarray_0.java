class Solution {
    public int maxLen(int[] arr) {
        // // Your code goes here
        // //Brute
        // //Store length of subarray
        // int max = 0;
        // //loop through each element
        // for(int i=0;i<arr.length;i++){
        //     //local sum to see if its 0
        //     int sum = 0;
        //     //go from curr ele to end
        //     for(int j = i; j<arr.length;j++){
        //         //add sum
        //         sum += arr[j];
        //         //if sum is 0 compute new max
        //         if(sum == 0){
        //             max = Math.max(max, j-i+1);
        //         }
        //     }
        // }
        // //return max
        // return max;
        //Optimal we can have a hashmap storing req values taking from n^2 to n.
        //prefix sum
        int max = 0;
        int sum = 0;
        // Map to store intermediate values with index
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<arr.length;i++){
            sum += arr[i];
            // if sum comes to 0 its from 0 to i largest so no need to check max
            if(sum == 0 ){
                max = i+1;
            }
            else{
                //if map has sum then go and check max length with i -  index stored
                if(map.containsKey(sum)){
                    max = Math.max(max, i-map.get(sum));
                }else{
                    //if not add sum to map
                    map.put(sum, i);
                }
                
            }
        }
        return max;
    }
}
