class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        int n = val.length;
        
        // Create an array of indices to track the items
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices based on the actual value-to-weight ratio in descending order
        Arrays.sort(indices, (a, b) -> {
            double ratioA = (double) val[a] / wt[a];
            double ratioB = (double) val[b] / wt[b];
            return Double.compare(ratioB, ratioA); // Sorts descending
        });

        double totalProfit = 0;
        int remainingCapacity = capacity;

        for (int i = 0; i < n; i++) {
            int idx = indices[i];

            // If the item can fit entirely, take it
            if (wt[idx] <= remainingCapacity) {
                remainingCapacity -= wt[idx];
                totalProfit += val[idx];
            } 
            // If it can't fit entirely, take the fractional part and break
            else {
                totalProfit += ((double) remainingCapacity / wt[idx]) * val[idx];
                break; 
            }
        }

        return totalProfit;
    }
}
