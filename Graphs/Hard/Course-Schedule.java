class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        List<List<Integer>> list = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < pre.length; i++){
            int c1 = pre[i][1];
            int c2 = pre[i][0];
            indegree[c2]++;
            list.get(c1).add(c2);
        }
        for(int i = 0; i<numCourses; i++){
            if(indegree[i]==0) stk.push(i);
        }
        if(stk.isEmpty()) return false;
        while(!stk.isEmpty()){
            int ver = stk.pop();
            for(int neigh : list.get(ver)){
                indegree[neigh]--;
                if(indegree[neigh] == 0) stk.push(neigh);
            }
        }
        for(int i = 0; i< numCourses; i++){
            if(indegree[i] != 0 ) return false;
        }
        return true;
    }
}
