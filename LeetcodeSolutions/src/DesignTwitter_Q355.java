import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class DesignTwitter_Q355 {
    HashMap<Integer, List<int[]>>userToPosts;
    HashMap<Integer,List<Integer>> userToFollows;
    int timeStamp;
    public DesignTwitter_Q355() {
        timeStamp=0;
        userToPosts=new HashMap<>();
        userToFollows=new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if(userToPosts.containsKey(userId)){
            List<int[]>ll=new ArrayList<>(userToPosts.get(userId));
            ll.add(new int[]{tweetId,timeStamp});
            userToPosts.put(userId,ll);
        }else{
            List<int[]>ll=new ArrayList<>();
            ll.add(new int[]{tweetId,timeStamp});
            userToPosts.put(userId,ll);
        }
        timeStamp++;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer>posts=new ArrayList<Integer>();
        PriorityQueue<int[]> mh=new PriorityQueue<>((a, b)->b[1]-a[1]);
        List<Integer>follows=new ArrayList<Integer>();
        if(userToFollows.containsKey(userId)){
            follows=new ArrayList<Integer>(userToFollows.get(userId));
        }
        follows.add(userId);
        for(int id:follows){
            if(userToPosts.containsKey(id)){
                List<int[]>ll=new ArrayList<>(userToPosts.get(id));
                int ti=0;
                while(ti<ll.size()){
                    mh.offer(ll.get(ti++));
                }
            }
        }
        int k=0;
        while(!mh.isEmpty()){
            if(k==10)break;
            posts.add(mh.poll()[0]);
            k++;
        }
        return posts;
    }

    public void follow(int followerId, int followeeId) {
        if(userToFollows.containsKey(followerId)){
            List<Integer>ll=userToFollows.get(followerId);
            if(ll.contains(Integer.valueOf(followeeId))){
                return;
            }
            ll.add(followeeId);
            userToFollows.put(followerId,ll);
        }else{
            List<Integer>ll=new ArrayList<Integer>();
            ll.add(followeeId);
            userToFollows.put(followerId,ll);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if(!userToFollows.containsKey(followerId))return;
        List<Integer>ll=new ArrayList<>(userToFollows.get(followerId));
        if(ll.size()==0)return;
        ll.remove(Integer.valueOf(followeeId));
        userToFollows.put(followerId,ll);
        return;
    }

    public static void main(String[] args) {
        DesignTwitter_Q355 twitter = new DesignTwitter_Q355();

        // User 1 posts tweets
        twitter.postTweet(1, 101);
        twitter.postTweet(1, 102);
        twitter.postTweet(1, 103);

        // User 2 follows User 1
        twitter.follow(2, 1);

        // User 2 retrieves their news feed
        List<Integer> newsFeed = twitter.getNewsFeed(2);
        System.out.println("User 2's News Feed: " + newsFeed); // Expected output: [103, 102, 101]

        // User 1 follows User 2
        twitter.follow(1, 2);

        // User 1 posts more tweets
        twitter.postTweet(1, 104);
        twitter.postTweet(1, 105);

        // User 1 retrieves their news feed
        List<Integer> newsFeedUser1 = twitter.getNewsFeed(1);
        System.out.println("User 1's News Feed: " + newsFeedUser1); // Expected output: [105, 104, 103, 102, 101]

        // User 2 retrieves their news feed again
        List<Integer> newsFeed2 = twitter.getNewsFeed(2);
        System.out.println("User 2's News Feed After Following User 1: " + newsFeed2); // Expected output: [105, 104, 103, 102, 101]
    }
}
