package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructItinerary {

  private class Pair implements Comparable<Pair> {
    String to;
    boolean visited;

    public Pair(String to) {
      this.to = to;
      visited = false;
    }


    @Override
    public int compareTo(Pair pair) {
      return to.compareTo(pair.to);
    }
  }

  private Map<String, List<Pair>> map = new HashMap<>();
  private int totalNum;

  public List<String> findItinerary(List<List<String>> tickets) {
    if (tickets == null || tickets.size() == 0) {
      return Collections.emptyList();
    }

    totalNum = tickets.size();
    for (List<String> ticket : tickets) {
      addTicket(map, ticket.get(0), ticket.get(1));
    }
    for (List<Pair> toList : map.values()) {
      toList.sort(new Comparator<Pair>() {
        @Override
        public int compare(Pair o1, Pair o2) {
          return o1.compareTo(o2);
        }
      });
    }

    String start = "JFK";
    String[] locs = new String[tickets.size() + 1];
    locs[0] = start;
    go(map, start, locs, 1);
    List<String> res = new ArrayList<>(locs.length);
    for (String loc : locs) {
      res.add(loc);
    }
    return res;
  }

  private void addTicket(Map<String, List<Pair>> map, String from, String to) {
    map.putIfAbsent(from, new ArrayList<>());
    map.get(from).add(new Pair(to));
  }

  private boolean go(Map<String, List<Pair>> map, String from, String[] res, int index) {
    if (index == totalNum + 1) {
      return true;
    }

    if (!map.containsKey(from)) {
      return false;
    }
    List<Pair> queue = map.get(from);
    for (Pair edge : queue) {
      if (edge.visited) {
        continue;
      }

      edge.visited = true;
      res[index] = edge.to;
      if (go(map, edge.to, res, index + 1)) {
        return true;
      } else {
        edge.visited = false;
      }
    }
    return false;
  }
}
