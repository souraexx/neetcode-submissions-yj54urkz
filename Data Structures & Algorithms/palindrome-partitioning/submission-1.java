class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        getPartition(s, result, new ArrayList<>(), 0);
        return result;
    }
    private void getPartition(String s, List<List<String>> result, List<String> ds, int index) {
        if (index == s.length()) {
            result.add(new ArrayList<>(ds));
            return;
        }
        for (int i=index; i<s.length(); i++) {
            String temp = s.substring(index, i+1);
            if (isPalin(temp)) {
                ds.add(temp);
                getPartition(s, result, ds, i+1);
                ds.remove(ds.size()-1);
            }
        }
    }
    private boolean isPalin(String temp) {
        int start = 0;
        int end = temp.length()-1;
        while(start<=end) {
            if (temp.charAt(start)!=temp.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
