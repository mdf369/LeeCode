package leetcode;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }

        int[] stack = new int[tokens.length];
        int stackIndex = 0;

        for (String token : tokens) {
            if (isOperator(token)) {
                int num2 = stack[--stackIndex];
                int num1 = stack[--stackIndex];
                int subRes = compute(num1, num2, token.charAt(0));
                stack[stackIndex++] = subRes;
            } else {
                stack[stackIndex++] = Integer.parseInt(token);
            }
        }
        return stack[0];
    }

    private boolean isOperator(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
    }

    private int compute(int num1, int num2, char op) {
        int res = 0;
        switch (op) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num1 / num2;
                break;
        }
        return res;
    }
}
