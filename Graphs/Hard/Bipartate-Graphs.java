class Solution {
    private boolean dfs(int index, int[][] graph, int[] col, int color){
        col[index] = color;
        for(int neig : graph[index]){
            if(col[neig] == -1){
                if(dfs(neig, graph, col, 1-color) == false) return false;
            }else if (col[neig] == color) return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int col[] = new int[graph.length];
        Arrays.fill(col, -1);
        for(int i = 0; i<graph.length;i++){
            if(col[i] == -1){
                if(dfs(i, graph, col, 0) == false) return false;
            }
        }
        return true;
    }
}
