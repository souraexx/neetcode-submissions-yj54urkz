class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        getComb(1, n, k, new ArrayList<>(), result);
        return result;
    }
    private void getComb(int index, int n, int k, List<Integer> ds, List<List<Integer>> result) {
        if (k==ds.size()) {
            result.add(new ArrayList<>(ds));
            return;
        }
        for (int i=index; i<=n; i++) { 
            //pick
            ds.add(i);
            getComb(i+1, n, k, ds, result);
            //not pick
            ds.remove(ds.size()-1);
        }
    }
}