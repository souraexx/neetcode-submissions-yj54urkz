class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++) {
            freq[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);// character, its freq
        for(int i=0;i<26;i++) {
            if (freq[i]>0) {
                pq.offer(new int[]{i, freq[i]});
            }
        }
        while(pq.size()>=2) {
            int[] first = pq.poll();
            int [] second = pq.poll();
            sb.append((char)(first[0]+'a'));
            sb.append((char)(second[0]+'a'));
            if (--first[1]>0) {
                pq.offer(first);
            }
            if (--second[1]>0) {
                pq.offer(second);
            }
        }
        while(!pq.isEmpty()) {
            int[] charac = pq.poll();
            if (charac[1]>1) return "";
            sb.append((char)(charac[0]+'a'));
        }
        return sb.toString();
    }
}