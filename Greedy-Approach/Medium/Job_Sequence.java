class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
    //   int n = deadline.length;
        
    //     // 1. Pair up deadlines and profits into a 2D array for easy sorting
    //     int[][] jobs = new int[n][2];
    //     int maxDeadline = 0;
    //     for (int i = 0; i < n; i++) {
    //         jobs[i][0] = deadline[i];
    //         jobs[i][1] = profit[i];
    //         maxDeadline = Math.max(maxDeadline, deadline[i]);
    //     }

    //     // 2. Sort the jobs based on profit in descending order
    //     Arrays.sort(jobs, (a, b) -> b[1] - a[1]);

    //     // 3. Create a schedule array to keep track of filled time slots
    //     // (Deadlines are 1-indexed, e.g., a deadline of 3 means slots 1, 2, or 3)
    //     boolean[] slots = new boolean[maxDeadline + 1];

    //     int count = 0;
    //     int maxProfit = 0;

    //     // 4. Iterate through sorted jobs and place them in their latest available slot
    //     for (int i = 0; i < n; i++) {
    //         int jobDeadline = jobs[i][0];
    //         int jobProfit = jobs[i][1];

    //         // Try to find a free slot from its deadline down to 1
    //         for (int j = jobDeadline; j > 0; j--) {
    //             if (!slots[j]) {
    //                 slots[j] = true; // Occupy the slot
    //                 count++;
    //                 maxProfit += jobProfit;
    //                 break; // Move to the next job
    //             }
    //         }
    //     }

    //     // 5. Return the total count of jobs completed and the max profit earned
    //     ArrayList<Integer> result = new ArrayList<>();
    //     result.add(count);
    //     result.add(maxProfit);
    //     return result;
    //TLE SO THIS SOL
    int n = deadline.length;
        int[][] jobs = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            jobs[i][0] = deadline[i];
            jobs[i][1] = profit[i];
        }

        // 1. Sort jobs based on deadline in ascending order
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));

        // 2. Min-Heap to store profits of the currently selected jobs
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 3. Iterate through the sorted jobs
        for (int i = 0; i < n; i++) {
            int currentDeadline = jobs[i][0];
            int currentProfit = jobs[i][1];

            // If we have open slots before this deadline, take the job
            if (currentDeadline > pq.size()) {
                pq.add(currentProfit);
            } 
            // If slots are full, check if this job is more profitable 
            // than the lowest-paying job we've accepted so far
            else if (currentDeadline == pq.size()) {
                if (!pq.isEmpty() && currentProfit > pq.peek()) {
                    pq.poll(); // Drop the low-profit job
                    pq.add(currentProfit); // Accept the high-profit job
                }
            }
        }

        // 4. Extract results from the heap
        int count = pq.size();
        int maxProfit = 0;
        while (!pq.isEmpty()) {
            maxProfit += pq.poll();
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(count);
        result.add(maxProfit);
        return result;
    }
}
