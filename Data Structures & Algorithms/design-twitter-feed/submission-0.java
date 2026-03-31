class Twitter {
    
    class Tweet {
        int time;
        int tweetId;
        Tweet(int time, int tweetId) {
            this.time = time;
            this.tweetId = tweetId;
        }
    }

    static int time = 0;
    Map<Integer, List<Tweet>> tweetMap;
    Map<Integer, Set<Integer>> followMap;

    public Twitter() {
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(time++, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b) -> b.time - a.time);

        if (tweetMap.containsKey(userId)) {
            for (Tweet t: tweetMap.get(userId)) {
                pq.offer(t);
            }
        }
        if (followMap.containsKey(userId)) {
            for(int f:followMap.get(userId)) {
                if (tweetMap.containsKey(f)) {
                    for (Tweet t: tweetMap.get(f)) {
                        pq.offer(t);
                    }
                }
            }
        }
        List<Integer> feed = new ArrayList<>();
        while (!pq.isEmpty() && feed.size()<10) {
            Tweet t = pq.poll();
            feed.add(t.tweetId);
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
