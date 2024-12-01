package Design;

import java.util.*;

public class Twitter {
    Map<Integer, User> setUsers;
    int timeStamp;

    public Twitter() {
        setUsers = new HashMap<>();
        timeStamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if (!setUsers.containsKey(userId))
            setUsers.put(userId, new User(userId));

        var currentUser = setUsers.get(userId);
        timeStamp++;
        currentUser.tweets.add(new Tweet(tweetId, userId, timeStamp));
    }

    public List<Integer> getNewsFeed(int userId) {
        // order by created timestamp
        // top 10 most recent tweet
        if (!setUsers.containsKey(userId)) {
            return new ArrayList<Integer>();
        }
        var user = setUsers.get(userId);
        Set<Tweet> userPost = user.tweets;
        Set<Tweet> userFollowingPosts = new HashSet<>();
        for (var follower : user.follows) {
            userFollowingPosts.addAll(follower.tweets);
        }

        Set<Tweet> total = new HashSet<>();
        total.addAll(userPost);
        total.addAll(userFollowingPosts);
        return returnTop10(total);
    }

    public List<Integer> returnTop10(Set<Tweet> tweets) {
        PriorityQueue<Tweet> minHeap = new PriorityQueue<>((a, b) -> b.timeStamp - a.timeStamp);
        for (var tweet : tweets) {
            minHeap.add(tweet);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 10 && !tweets.isEmpty(); i++) {
            var element = minHeap.poll();
            if (element != null) result.add(element.tweetId);
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (!setUsers.containsKey(followerId)) setUsers.put(followerId, new User(followerId));
        if (!setUsers.containsKey(followeeId)) setUsers.put(followeeId, new User(followeeId));

        var follower = setUsers.get(followerId);
        var follows = follower.follows;
        var followee = setUsers.get(followeeId);
        follows.add(followee);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!setUsers.containsKey(followerId)) setUsers.put(followerId, new User(followerId));
        if (!setUsers.containsKey(followeeId)) setUsers.put(followeeId, new User(followeeId));

        var follower = setUsers.get(followerId);
        var follows = follower.follows;
        var followee = setUsers.get(followeeId);
        follows.remove(followee);
    }


    static class User {
        public int userId;
        public Set<User>  follows;
        public Set<Tweet> tweets;

        public User(int userId) {
            this.follows = new HashSet<>();
            this.tweets = new HashSet<>();
            this.userId = userId;
        }
    }

    static class Tweet {
        public int tweetId;
        public int userId;
        public int timeStamp;

        public Tweet(int tweetId, int userId, int timeStamp) {
            this.tweetId = tweetId;
            this.userId = userId;
            this.timeStamp = timeStamp;
        }
    }
}
