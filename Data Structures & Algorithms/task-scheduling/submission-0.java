class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task: tasks) {
            freq[task-'A']++;
        }
        int maxFreq = 0;
        int maxCount = 0;
        for(int frequency:freq) {
            if (frequency>maxFreq) {
                maxFreq = frequency;
            }
        }
        for (int frequency:freq) {
            if (frequency==maxFreq) {
                maxCount++;
            }
        }
        
        int time = ((n+1)*(maxFreq-1))+maxCount;
        return Math.max(tasks.length, time);
    }
}
