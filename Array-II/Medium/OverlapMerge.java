class Solution {
    public int[][] merge(int[][] intervals) {
        // //sort the intervals
        // Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // ArrayList<int[]> res = new ArrayList<>();
        // int i= 0;
        // //iterate through them
        // while(i<intervals.length){
        //     //j to iterate through the subsequent intervals
        //     int j = i+1;
        //     //store the rightmost value for each interval
        //     int right = intervals[i][1];
        //     //iterate j till its n or till start of j is less than right
        //     while(j < intervals.length && right >= intervals[j][0]){
        //         right = Math.max(intervals[j][1], right);
        //         j++;
        //     }   
        //     //store values in intervals and add to res
        //     res.add(new int[]{intervals[i][0], right});
        //     //update i
        //     i = j;
        // }
        // //return res as array
        // return res.stream().toArray(int[][]::new);
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<List<Integer>> res = new ArrayList<>();
        for(int[] interval: intervals){
            //if list is empty or value is lesser just insert
            if(res.size() == 0 || res.get(res.size()-1).get(1) < interval[0]){
                res.add(Arrays.asList(interval[0],interval[1]));
            }else{
                //else update interval end
                int last = res.get(res.size()-1).get(1);
                int maxend =  Math.max(last, interval[1]);
                res.get(res.size()-1).set(1, maxend);
            }
        }
        return res.stream()
              .map(innerList -> innerList.stream()
              .mapToInt(Integer::intValue) 
              .toArray())
              .toArray(int[][]::new);
    }
}
