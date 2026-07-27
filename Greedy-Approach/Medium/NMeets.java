class Solution {
    public int maxMeetings(int[] start, int[] end) {
       //your code goes here
    //    Arrays.sort(start);
    //    Arrays.sort(end);
    //    int count = 1;
    //    int j = 0;
    //    for(int i = 0; i < start.length-1; i++){
    //         if(start[i+1] <= end[j]) continue;
    //         count++; 
    //         j++;        
    //    }
    //    return count;
        int n = start.length;
        int meets[][] = new int[n][n];
        for(int i = 0; i < n; i++){
            meets[i][0] = start[i];
            meets[i][1] = end[i];
        }
        Arrays.sort(meets, (a,b)->a[1]-b[1]);
        int count = 1;
        int lastend = meets[0][1];
        for(int i = 1; i < n; i++){
            if(meets[i][0] > lastend){
                count++;
                lastend = meets[i][1];
            }
        }
        return count;
    }
}
