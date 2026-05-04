class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.get(0).add(1);
        for (int i = 2; i <= numRows; i++) {
            ArrayList<Integer> row = new ArrayList<>(Collections.nCopies(i, 1));
            for (int j = 1; j < i - 1; j++) {
                row.set(j, res.get(i - 2).get(j - 1) + res.get(i - 2).get(j));
            }
            res.add(row);
        }
        return res;
    }
}
