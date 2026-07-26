class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(a)-map.get(b)
        );
        for(int key: map.keySet()){
            pq.add(key);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        
        return res;
    }
}
// class Solution {
//     public static int[] topKFrequent(int[] nums, int k) {
//         int min=Integer.MAX_VALUE; 
//         int max=Integer.MIN_VALUE; 
//         for(int num:nums) { 
//             if(num>max)max=num; 
//             if(num<min)min=num; 
//         } 
//         int[] freq=new int[max-min+1]; 
//         int highFreq=0; 
//         for(int i:nums) { 
//             int idx=i-min; 
//             int count=++freq[idx]; 
//             if(count>highFreq)
//             highFreq=count; 
//         } 
//         List<Integer>[] bucketList=new ArrayList[highFreq]; 
//         for(int i=0;i<freq.length;i++) { 
//             int freqIdx =freq[i]-1; 
//             if(freqIdx ==-1)continue; 
//             if(bucketList[freqIdx]==null) bucketList[freqIdx ]=new ArrayList<>(); 
//             bucketList[freqIdx ].add(i+min); 
//         } 
//         int[] res=new int[k]; 
//         int idx=0; 
//         for (int i=highFreq-1;i>=0;i--) { 
//             if(bucketList[i]==null)continue; 
//             for(int num:bucketList[i]) { 
//                 res[idx++]=num; 
//                 if(idx==k)return res; 
//             } 
//         } 
//         return res;
//     }
//     static {
//         int[] input = {1, 1, 2, 2, 3};
//         for (int i = 0; i < 200; i++) {
//             topKFrequent(input, 2);
//         }
//     }
// }
