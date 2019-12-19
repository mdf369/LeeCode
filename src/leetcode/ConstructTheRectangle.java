package leetcode;

public class ConstructTheRectangle {

  public int[] constructRectangle(int area) {
    int width = (int) Math.sqrt(area);
    int length = area;
    while (width > 1) {
      if (area % width == 0) {
        length = area / width;
        break;
      }
      width--;
    }
    return new int[]{length, width};
  }
}
