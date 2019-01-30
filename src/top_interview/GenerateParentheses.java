package top_interview;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    private List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();

        go("", n, n);
        return res;
    }

    private void go(String str, int left, int right){
        if (left == 0 && right == 0){
            res.add(str);
            return;
        }

        if (left > 0){
            go(str + '(', left - 1, right);
        }

        if (right > left){
            go(str + ')', left, right - 1);
        }
    }
}
