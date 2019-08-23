package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import javafx.util.Pair;

public class Twitter {

  private final int LIMIT_NUM = 10;

  private long timer = 0;

  private class User {

    int userId;
    LinkedList<Pair<Long, Integer>> tweets;
    Set<Integer> followList;

    public User(int userId) {
      this.userId = userId;

      tweets = new LinkedList<>();
      followList = new HashSet<>();
      followList.add(userId);
    }

    public void postTweet(int tweetId) {
      tweets.addFirst(new Pair<>(timer++, tweetId));
      if (tweets.size() > LIMIT_NUM) {
        tweets.removeLast();
      }
    }

    public void follow(int followId) {
      followList.add(followId);
    }

    public void unfollow(int followId) {
      if (followId == userId) {
        return;
      }
      followList.remove(followId);
    }
  }

  private Map<Integer, User> userMap;

  /** Initialize your data structure here. */
  public Twitter() {
    userMap = new HashMap<>();
  }

  /** Compose a new tweet. */
  public void postTweet(int userId, int tweetId) {
    userMap.putIfAbsent(userId, new User(userId));
    userMap.get(userId).postTweet(tweetId);
  }

  /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
  public List<Integer> getNewsFeed(int userId) {
    if (!userMap.containsKey(userId)) {
      return Collections.emptyList();
    }

    Set<Integer> followSet = userMap.get(userId).followList;
    LinkedList<Pair<Long, Integer>>[] queues = new LinkedList[followSet.size()];
    int index = 0;
    for (Integer followId : followSet) {
      if (!userMap.containsKey(followId)) {
        continue;
      }
      queues[index++] = userMap.get(followId).tweets;
    }

    Queue<Pair<Long, Integer>> res = new PriorityQueue<>(new Comparator<Pair<Long, Integer>>() {
      @Override
      public int compare(Pair<Long, Integer> o1, Pair<Long, Integer> o2) {
        return (int) (o1.getKey() - o2.getKey());
      }
    });
    for (LinkedList<Pair<Long, Integer>> tweets : queues) {
      if (tweets == null) {
        continue;
      }
      res.addAll(tweets);
      while (res.size() > LIMIT_NUM) {
        res.remove();
      }
    }

    int size = Math.min(LIMIT_NUM, res.size());
    int[] arr = new int[size];
    for (int i = size - 1; i >= 0; i--) {
      arr[i] = res.poll().getValue();
    }
    List<Integer> list = new ArrayList<>(arr.length);
    for (int id : arr) {
      list.add(id);
    }
    return list;
  }

  /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
  public void follow(int followerId, int followeeId) {
    userMap.putIfAbsent(followerId, new User(followerId));
    userMap.get(followerId).follow(followeeId);
  }

  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
  public void unfollow(int followerId, int followeeId) {
    if (!userMap.containsKey(followerId)) {
      return;
    }
    userMap.get(followerId).unfollow(followeeId);
  }
}
