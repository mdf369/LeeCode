package leetcode;

public class IntegerToEnglishWords {

  public String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }

    String res = "";
    String[] words = new String[]{"Billion", "Million", "Thousand"};

    for (int i = 0; i < 3; i++) {
      int shift = (int) Math.pow(10, (3 - i) * 3);
      int baseNum = num / shift;
      if (baseNum > 0) {
        int base = baseNum * shift;
        num -= base;
        res += " " + convertLess1000(baseNum) + " " + words[i];
      }
    }

    res += " " + convertLess1000(num);
    return res.trim();
  }

  private String convertLess1000(int num) {
    if (num < 20) {
      return convertLess20(num);
    }

    String res = "";
    int hundred = num / 100;
    if (hundred > 0) {
      res += convertLess20(hundred) + " Hundred";
      num -= hundred * 100;
    }

    if (num < 20) {
      res += " " + convertLess20(num);
    } else {
      int ten = num / 10;
      res += " " + convertTen(ten);

      int one = num - ten * 10;
      if (one > 0) {
        res += " " + convertLess20(one);
      }
    }
    return res.trim();
  }

  private String convertTen(int ten) {
    String res = null;
    switch (ten) {
      case 2:
        res = "Twenty";
        break;
      case 3:
        res = "Thirty";
        break;
      case 4:
        res = "Forty";
        break;
      case 5:
        res = "Fifty";
        break;
      case 6:
        res = "Sixty";
        break;
      case 7:
        res = "Seventy";
        break;
      case 8:
        res = "Eighty";
        break;
      case 9:
        res = "Ninety";
        break;
    }
    return res;
  }

  private String convertLess20(int num) {
    String res = null;
    switch (num) {
      case 0:
        res = "";
        break;
      case 1:
        res = "One";
        break;
      case 2:
        res = "Two";
        break;
      case 3:
        res = "Three";
        break;
      case 4:
        res = "Four";
        break;
      case 5:
        res = "Five";
        break;
      case 6:
        res = "Six";
        break;
      case 7:
        res = "Seven";
        break;
      case 8:
        res = "Eight";
        break;
      case 9:
        res = "Nine";
        break;
      case 10:
        res = "Ten";
        break;
      case 11:
        res = "Eleven";
        break;
      case 12:
        res = "Twelve";
        break;
      case 13:
        res = "Thirteen";
        break;
      case 14:
        res = "Fourteen";
        break;
      case 15:
        res = "Fifteen";
        break;
      case 16:
        res = "Sixteen";
        break;
      case 17:
        res = "Seventeen";
        break;
      case 18:
        res = "Eighteen";
        break;
      case 19:
        res = "Nineteen";
        break;
    }
    return res;
  }
}
