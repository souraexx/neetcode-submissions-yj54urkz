class TimeMap {

    Map<String, List<Pair>> map; // key - value and timestamp

    static class Pair {
        String value;
        int timestamp;
        public Pair(String v, int t) {
            value = v;
            timestamp = t;
        }
    }

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Pair> keyVal = map.get(key);
        int low = 0;
        int high = keyVal.size()-1;
        String ans ="";
        while (low<=high) {
            int mid = (low+high)/2;
            int midTime = keyVal.get(mid).timestamp;
            if (midTime<=timestamp) {
                ans = keyVal.get(mid).value;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
}
