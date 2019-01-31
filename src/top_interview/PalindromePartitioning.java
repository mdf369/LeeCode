package top_interview;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() == 0) {
            return res;
        }

        int[] indexes = new int[s.length()];
        cut(s, 0, 0, indexes, res);
        return res;
    }

    private void cut(String s, int start, int depth, int[] indexes, List<List<String>> res) {
        if (start == s.length()) {
            List<String> subRes = new ArrayList<>();
            int head = 0;
            for (int i = 0; i < depth; i++) {
                subRes.add(s.substring(head, indexes[i]));
                head = indexes[i];
            }
            res.add(subRes);
            return;
        }

        int index = start + 1;
        while (index <= s.length()) {
            if (isPalindrome(s.substring(start, index))) {
                indexes[depth] = index;
                cut(s, index, depth + 1, indexes, res);
            }
            index++;
        }
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return false;
        }
        int start = 0, end = s.length() - 1;
        while (start < end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        return start >= end;
    }
}
