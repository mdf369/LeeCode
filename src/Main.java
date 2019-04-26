import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

  private static final int FIELD_NUM = 7;
  private static final int[] USEFUL_FIELDS = new int[]{0, 6, 5, 3};
  private static final char SPLITTER = ',';
  private static final char QUOTE = '"';
  private static final String DOUBLE_QUOTES = "\"\"";

  private static final String BIO_NOTES_FORMAT = "%s, %s years old, is from %s and is interested in %s.";

  private static ExecutorService fixedThreadPool = Executors.newCachedThreadPool();

  static class SimplifyWorker implements Callable<String> {

    private String field;

    public SimplifyWorker(String field) {
      this.field = field;
    }

    private String simplify(String field) throws InterruptedException {
      if (field.length() == 0) {
        return field;
      }

      if (field.charAt(0) == QUOTE && field.charAt(field.length() - 1) == QUOTE) {
        field = field.substring(1, field.length() - 1);
      }

      Thread.sleep(100);
      return field.replace(DOUBLE_QUOTES, "" + QUOTE);
    }

    @Override
    public String call() throws Exception {
      return simplify(field);
    }
  }

//  public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//
//    while (sc.hasNext()) {
//      String line = sc.nextLine();
//      outputBioNote(line);
//    }
//  }

  private static void outputBioNote(String line) throws ExecutionException, InterruptedException {
    String[] fields = split(line);

    fixedThreadPool = Executors.newFixedThreadPool(USEFUL_FIELDS.length);
    Future<String>[] workers = new Future[USEFUL_FIELDS.length];
    for (int i = 0; i < USEFUL_FIELDS.length; i++) {
      int index = USEFUL_FIELDS[i];
      workers[i] = fixedThreadPool.submit(new SimplifyWorker(fields[index]));
    }
    fixedThreadPool.shutdown();
    for (int i = 0; i < workers.length; i++) {
      int index = USEFUL_FIELDS[i];
      fields[index] = workers[i].get();
    }

//    for (int i = 0; i < USEFUL_FIELDS.length; i++) {
//      int index = USEFUL_FIELDS[i];
//      fields[index] = simplify(fields[index]);
//    }

    System.out.println(buildBioNote(fields));
  }

  private static String simplify(String field) throws InterruptedException {
    if (field.length() == 0) {
      return field;
    }

    if (field.charAt(0) == QUOTE && field.charAt(field.length() - 1) == QUOTE) {
      field = field.substring(1, field.length() - 1);
    }

    Thread.sleep(100);
    return field.replace(DOUBLE_QUOTES, "" + QUOTE);
  }

  private static String buildBioNote(String[] fields) {
    return String.format(BIO_NOTES_FORMAT, fields[0], fields[6], fields[5], fields[3]);
  }

  private static String[] split(String line) {
    String[] fields = new String[FIELD_NUM];
    int index = 0;
    int pre = 0;
    for (int i = 0; i < line.length(); i++) {
      if (line.charAt(i) == SPLITTER) {
        fields[index++] = line.substring(pre, i);
        pre = i + 1;
      }
      if (line.charAt(i) == QUOTE) {
        i = findRightQuote(line, i + 1);
      }
    }
    fields[index] = line.substring(pre);
    return fields;
  }

  private static int findRightQuote(String line, int start) {
    while (start < line.length()) {
      start = line.indexOf(QUOTE, start);
      if (isDoubleQuotes(line, start)) {
        start = findDoubleQuotes(line, start + DOUBLE_QUOTES.length()) + DOUBLE_QUOTES.length();
      } else {
        return start;
      }
    }
    return -1;
  }

  private static int findDoubleQuotes(String line, int start) {
    return line.indexOf(DOUBLE_QUOTES, start);
  }

  private static boolean isDoubleQuotes(String line, int index) {
    index++;
    if (index == line.length()) {
      return false;
    }
    return line.charAt(index) == QUOTE;
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    String line = "\"Dongfang \"\"Mao\"\"\",Shark,952945925@qq.com,\"basketball, fitness\",666,Chengdu,24";
    long time = System.currentTimeMillis();
    for (int i = 0; i < 100; i++) {
      outputBioNote(line);
    }
    System.out.println(System.currentTimeMillis() - time);
  }
}