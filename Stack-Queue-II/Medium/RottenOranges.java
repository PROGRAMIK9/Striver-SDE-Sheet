class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int total_oranges  = 0;
        int count = 0;
        Queue<int[]> rotten = new LinkedList<>();
        for(int i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] != 0) total_oranges++;
                if(grid[i][j] == 2){
                    rotten.offer(new int[]{i,j});
                }
            }
        }
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        int days  = 0;
        // BFS loop to rot oranges level by level
        while (!rotten.isEmpty()) {
            // Number of rotten oranges to process in this round
            int k = rotten.size();
            // Add to the count of rotted oranges
            count += k;
            // Process each rotten orange
            for (int i = 0; i < k; i++) {
                int[] pos = rotten.poll();
                int x = pos[0], y = pos[1];
                // Check all 4 directions
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    // Skip out-of-bound or non-fresh cells
                    if (nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] != 1)
                        continue;

                    // Mark orange as rotten
                    grid[nx][ny] = 2;

                    // Add new rotten orange to queue
                    rotten.add(new int[]{nx, ny});
                }
            }

            // Only increase time if we still have new oranges to process
            if (!rotten.isEmpty()) days++;
        }

        // If all oranges are rotted, return days; otherwise return -1
        return total_oranges == count ? days : -1;
    }
}
