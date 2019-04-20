import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (sc.hasNext()) {
      int n = sc.nextInt();

      String[] words = new String[n];
      for (int i = 0; i < n; i++) {
        words[i] = sc.next();
      }
      String T = sc.next();

      if (n < 1) {
        System.out.println(0);
        continue;
      }

      Queue<int[]> candidates = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
          return o1[1] - o2[1];
        }
      });
      for (int i = 0; i < words.length; i++) {
        updateCandidates(candidates, T, 0, words[i], new int[]{0, 0, i});
      }

      int count = 0;
      int TIndex = 0;
      while (!candidates.isEmpty()) {
        int[] candidate = candidates.poll();
        if (candidate[0] < TIndex) {
          updateCandidates(candidates, T, TIndex, words[candidate[2]], candidate);
          continue;
        }
        TIndex = candidate[1];
        count++;

        updateCandidates(candidates, T, TIndex, words[candidate[2]], candidate);
      }
      System.out.println(count);
    }
  }

  private static void updateCandidates(Queue<int[]> candidates, String T, int TIndex, String word, int[] oldCandidate) {
    int index = T.indexOf(word, TIndex);
    if (index != -1) {
      oldCandidate[0] = index;
      oldCandidate[1] = index + word.length();
      candidates.add(oldCandidate);
    }
  }
}