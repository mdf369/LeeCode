import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import javafx.util.Pair;

public class Main {

  public static int getDayDiff(Date date1,Date date2) {
    return (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
  }

  public static int getHourDiff(Date date1,Date date2) {
    return (int) ((date2.getTime() - date1.getTime()) / 3600);
  }

  private static int compare(Date time, Pair<Date, Date> interval) {
    if (time.compareTo(interval.getKey()) == -1) {
      return -1;
    } else if (time.compareTo(interval.getValue()) == 1) {
      return 1;
    } else {
      return 0;
    }
  }

  private static Pair<Integer, Integer> getOverLap(Date time, List<Pair<Date, Date>>[] schedules, int[] mem, int K) {
    for (int i = 0; i < K; i++) {
      List<Pair<Date, Date>> intervalList = schedules[i];
      int startIndex = mem[i];

      while (startIndex < intervalList.size()) {
        int status = compare(time, intervalList.get(startIndex));
        if (status == 0) {
          mem[i] = startIndex + 1;
          return new Pair<>(i, startIndex);
        } else if (status == -1) {
          mem[i] = startIndex;
          break;
        } else {
          startIndex++;
          mem[i] = startIndex;
        }
      }
    }
    return null;
  }

  private static Pair<Integer, Integer> getNextInterval(Date time, List<Pair<Date, Date>>[] schedules, int[] mem, int K) {
    Date minStart = null;
    int minRoom = -1;
    int minIndex = -1;

    for (int i = 0; i < K; i++) {
      List<Pair<Date, Date>> intervalList = schedules[i];
      int startIndex = mem[i];
      if (startIndex == intervalList.size()) {
        continue;
      }

      Pair<Date, Date> interval = intervalList.get(startIndex);
      if (minStart == null) {
        minStart = interval.getKey();
        minRoom = i;
        minIndex = startIndex;
      } else {
        if (minStart.compareTo(interval.getKey()) == 1) {
          minStart = interval.getKey();
          minRoom = i;
          minIndex = startIndex;
        }
      }
    }
    return new Pair<>(minRoom, minIndex);
  }

  private static Date checkDay(List<Pair<Date, Date>>[] schedules, int K) {
    int[] mem = new int[K];

    Date time = null;
    while (true) {
      Pair<Integer, Integer> pair = getOverLap(time, schedules, mem, K);
      if (pair == null) {
        Pair<Integer, Integer> nextIntervalIndex = getNextInterval(time, schedules, mem, K);
        if (nextIntervalIndex == null) {
          return null;
        }

        Pair<Date, Date> nextInterval = schedules[nextIntervalIndex.getKey()].get(nextIntervalIndex.getValue());
        int hourdiff = getHourDiff(time, nextInterval.getKey());
        if (hourdiff >= 2) {
          return time;
        }

        time = nextInterval.getValue();
      } else {
        time = schedules[pair.getKey()].get(pair.getValue()).getValue();
      }
    }
  }

  public static void main(String[] args) throws ParseException {
    final int LEN = 7;
    Scanner scanner = new Scanner(System.in);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("yyyy-MM-ddTHH:mm:ss");

    Date T = simpleDateFormat.parse(scanner.nextLine());
    int K = Integer.parseInt(scanner.nextLine());

    List<Pair<Date, Date>>[][] schedules = new List[LEN][K];
    for (int i = 0; i < LEN; i++) {
      for (int j = 0; j < K; j++) {
        schedules[i][j] = new ArrayList<>();
      }
    }
    for (int i = 0; i < K; i++) {
      String[] words = scanner.nextLine().split(",");
      for (String word : words) {
        String[] pair = word.split("~");
        Date start = simpleTimeFormat.parse(pair[0]);
        Date end = simpleTimeFormat.parse(pair[1]);

        int dayDiff = getDayDiff(T, start);
        schedules[dayDiff - 1][i].add(new Pair<>(start, end));
      }
    }

    scanner.close();

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(T);
    calendar.add(Calendar.DAY_OF_MONTH, 7);
    Date MAX = calendar.getTime();
  }
}