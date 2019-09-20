package leetcode;

public class UTF8Validation {

  private int getStartOneNum(int value) {
    int count = 0;
    int limit = (int) Math.pow(2, 7);
    while (value >= limit && value > 0) {
      count++;
      value -= limit;
      limit = limit >> 1;
    }
    return count;
  }

  public boolean validUtf8(int[] data) {
    int min = (int) Math.pow(2, 7);
    int max = (int) (Math.pow(2, 8) - 1 - Math.pow(2, 6));

    int index = 0;
    while (index < data.length) {
      int oneNum = getStartOneNum(data[index]);
      if (oneNum == 0) {
        index++;
        continue;
      }

      if (oneNum == 1 || oneNum > 4 || index + oneNum > data.length) {
        return false;
      }
      for (int i = 1; i < oneNum; i++) {
        if (data[index + i] < min || data[index + i] > max) {
          return false;
        }
      }
      index += oneNum;
    }
    return true;
  }
}
