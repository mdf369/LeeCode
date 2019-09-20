package kickstart;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CodeEatSwitcher {

  private static class Slot {
    int index;
    int value;
    double rate;
    boolean valid;

    public Slot(int index, int value) {
      this.index = index;
      this.value = value;
      this.valid = true;
    }
  }

  private static class Arrangement {
    Slot cSlot;
    Slot eSlot;
    boolean flag;

    public Arrangement(Slot cSlot, Slot eSlot, boolean flag) {
      this.cSlot = cSlot;
      this.eSlot = eSlot;
      this.flag = flag;
    }
  }

  private static int getSum(Slot[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i].value;
    }
    return sum;
  }

  private static Arrangement getNextSlot(int S, Slot[] cSlots, Slot[] eSlots, Map<Integer, Slot> cMap, Map<Integer, Slot> eMap) {
    while (cIndex < S && !cSlots[cIndex].valid) {
      cIndex++;
    }
    while (eIndex < S && !eSlots[eIndex].valid) {
      eIndex++;
    }

    if (cIndex == S || eIndex == S) {
      return null;
    }

    Slot cSlot = cSlots[cIndex];
    Slot eSlot = eSlots[eIndex];
    boolean flag;
    if (cSlot.rate >= eSlot.rate) {
      eSlot = eMap.get(cSlot.index);
      flag = true;
    } else {
      cSlot = cMap.get(eSlot.index);
      flag = false;
    }
    return new Arrangement(cSlot, eSlot, flag);
  }

  static int cIndex = 0;
  static int eIndex = 0;

  private static boolean judgeOneDay(Slot[] C, Slot[] E, Map<Integer, Slot> cMap, Map<Integer, Slot> eMap, double A, double B, int S) {
    for (int i = 0; i < S; i++) {
      C[i].rate = C[i].value / A;
      E[i].rate = E[i].value / B;
    }

    double ALeft = 1;
    double BLeft = 1;
    cIndex = eIndex = 0;
    while (true) {
      Arrangement nextArrangement = getNextSlot(S, C, E, cMap, eMap);
      if (nextArrangement == null) {
        break;
      }

      boolean flag = nextArrangement.flag;
      Slot cSlot = nextArrangement.cSlot;
      Slot eSlot = nextArrangement.eSlot;
      cSlot.valid = false;
      eSlot.valid = false;
      if (flag) {
        if (cSlot.rate >= ALeft) {
          BLeft -= eSlot.rate * (1 - ALeft / cSlot.rate);
          ALeft = 0;
          for (int j = eIndex; j < S; j++) {
            if (!E[j].valid) {
              continue;
            }
            BLeft -= E[j].rate;

            if (BLeft <= 0.000001) {
              return true;
            }
          }
          return false;
        }

        ALeft -= cSlot.rate;
      } else {
        if (eSlot.rate >= BLeft) {
          ALeft -= cSlot.rate * (1 - BLeft / eSlot.rate);
          BLeft = 0;
          for (int j = cIndex; j < S; j++) {
            if (!C[j].valid) {
              continue;
            }
            ALeft -= C[j].rate;

            if (ALeft <= 0.000001) {
              return true;
            }
          }
          return false;
        }

        BLeft -= eSlot.rate;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    for (int t = 0; t < T; t++) {
      int D = scanner.nextInt();
      int S = scanner.nextInt();
      Slot[] C = new Slot[S];
      Slot[] E = new Slot[S];
      Map<Integer, Slot> cMap = new HashMap<>();
      Map<Integer, Slot> eMap = new HashMap<>();
      for (int i = 0; i < S; i++) {
        C[i] = new Slot(i, scanner.nextInt());
        E[i] = new Slot(i, scanner.nextInt());
        cMap.put(i, C[i]);
        eMap.put(i, E[i]);
      }
      int[] A = new int[D];
      int[] B = new int[D];
      for (int i = 0; i < D; i++) {
        A[i] = scanner.nextInt();
        B[i] = scanner.nextInt();
      }

      int CSUM = getSum(C);
      int ESUM = getSum(E);
      Comparator<Slot> slotComparator = (o1, o2) -> ((Double)o2.rate).compareTo(o1.rate);
      Arrays.sort(C, slotComparator);
      Arrays.sort(E, slotComparator);

      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < D; i++) {
        boolean canFulfill;
        if (A[i] > CSUM || B[i] > ESUM) {
          canFulfill = false;
        } else if (A[i] == 0 || B[i] == 0) {
          if (A[i] == 0 && B[i] == 0) {
            canFulfill = true;
          } else if (A[i] == 0) {
            canFulfill = ESUM >= B[i];
          } else {
            canFulfill = CSUM >= A[i];
          }
        } else {
          canFulfill = judgeOneDay(C, E, cMap, eMap, A[i], B[i], S);
        }
        builder.append(canFulfill ? 'Y' : 'N');
      }

      System.out.println("Case #" + (t + 1) + ": " + builder.toString());
    }
    scanner.close();
  }
}
