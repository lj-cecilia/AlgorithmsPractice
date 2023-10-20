import java.util.*;

public class DesignTwitter {
    //links to answer/reference: https://leetcode.com/problems/design-twitter/solutions/82825/java-oo-design-with-most-efficient-function-getnewsfeed/?orderBy=hot
    Twitter tweet = new Twitter();
}
class Twitter {
    public static int timeStamp = 0;

    private Map<Integer, User> userMap;

    private class Tweet {
        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id) {
            this.id = id;
            time = timeStamp++;
            next = null;
        }
    }

    public class User {
        public int id;
        public Set<Integer> followed;
        public Tweet tweet_head;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id); // first follow itself
            tweet_head = null;
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unfollow(int id) {
            followed.remove(id);
        }


        // everytime user post a new tweet, add it to the head of tweet list.
        public void post(int id) {
            Tweet t = new Tweet(id);
            t.next = tweet_head;
            tweet_head = t;
        }
    }

    public Twitter() {
        userMap = new HashMap<Integer, User>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User user = new User(userId);
            userMap.put(userId, user);
        }
        //call user defined function post, put the tweet with this userId to the head of our tweet list
        userMap.get(userId).post(tweetId);
    }

    //get the news from all the people this user follow
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new LinkedList<>();
        //for a non-existant user, we don't need to worry about news
        if (!userMap.containsKey(userId)) return result;

        Set<Integer> followedUsers = userMap.get(userId).followed;
        PriorityQueue<Tweet> q = new PriorityQueue<Tweet>(followedUsers.size(), (a, b) -> (b.time - a.time));
        for (int followedUser : followedUsers) {
            Tweet tweet = userMap.get(followedUser).tweet_head;
            if (tweet != null) q.add(tweet);
        }

        int countOfTweets = 0;
        while (!q.isEmpty() && countOfTweets < 10) {
            Tweet tweet = q.poll();
            result.add(tweet.id);
            countOfTweets++;
            if (tweet.next != null) q.add(tweet.next);
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User u = new User(followerId);
            userMap.put(followerId, u);
        }
        if (!userMap.containsKey(followeeId)) {
            User u = new User(followeeId);
            userMap.put(followeeId, u);
        }
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId)
            return;
        userMap.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

