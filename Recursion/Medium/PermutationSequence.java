class Solution {
    List<String> result = new ArrayList<>();
    boolean[] isVisited;
    private void solve(int n, StringBuilder permutation){
        if(permutation.length() == n){
            result.add(permutation.toString());
            return;
        }
        for(int i = 1; i <= n; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                permutation.append(i);
                solve(n, permutation);
                isVisited[i] = false;
                permutation.deleteCharAt(permutation.length() -1);
            }
        }
    }
    public String getPermutation(int n, int k) {
        // isVisited = new boolean[n+1];
        // solve(n, new StringBuilder());
        // return result.get(k-1);
        List<Character> values = new ArrayList<>();
        String result = "";
        int fact = 1;
        for(int i = 1; i <= n; i++){
            values.add((char)(i+'0'));//add all characters
            fact *= i;//find fact
        }
        k = k-1;//subtract k by 1 to avoid array bounds
        for(int i = n; i>=1; i--){//go from back
            fact/=i; // find the earlier fact
            int index = k/fact;// index =  k/fact(gives one of the valid indices)
            result+=values.get(index);//add to string
            if(i==1) break;
            values.remove(index);//remove the value from list cz no repeat
            k = k%fact;//mod k with fact to get a smaller value to deal with next time 
        }
        return result;
    }
}
