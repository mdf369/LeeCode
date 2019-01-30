package top_interview;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int max = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int start, end;
            start = end = i;

            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            }
            start++;
            end--;
            if(max < end - start + 1){
                max = end - start + 1;
                res = s.substring(start, end + 1);
            }

            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                start = i;
                end = i + 1;
                while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                    start--;
                    end++;
                }
                start++;
                end--;
                if(max < end - start + 1){
                    max = end - start + 1;
                    res = s.substring(start, end + 1);
                }
            }
        }

        return res;
    }
}
