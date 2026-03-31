class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> freqMap = new HashMap<>();

        if (strs.length == 1) {
            result.add(Arrays.asList(strs[0]));
            return result;
        }

        for (String word : strs) {
            char ch[] = word.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);

            if (!freqMap.containsKey(key)) {
                freqMap.put(key, new ArrayList<>());
            }
            freqMap.get(key).add(word);
        }

        for(List<String> anagrams: freqMap.values()) {
            result.add(anagrams);
        }

        return result;
    }
}
