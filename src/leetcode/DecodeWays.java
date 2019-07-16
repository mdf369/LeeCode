package leetcode;

public class DecodeWays {

    public int numDecodings(String s) {
        int[] mem = new int[s.length()];
        for (int i = 0; i < mem.length; i++) {
            mem[i] = -1;
        }
        int last = s.length() - 1;
        if (s.charAt(last) == '0'){
            mem[last] = 0;
        } else {
            mem[last] = 1;
        }

        return decode(s, 0, mem);
    }

    private int decode(String s, int index, int[] mem){
        if (index >= s.length()){
            return 1;
        }

        if (mem[index] >= 0){
            return mem[index];
        }

        if (s.charAt(index) - '0' > 2){
            mem[index] = decode(s, index + 1, mem);
        } else if (s.charAt(index) == '0'){
            return 0;
        } else if (s.charAt(index) == '2'){
            int num = decode(s, index + 1, mem);
            if (s.charAt(index + 1) - '0' <= 6){
                num += decode(s, index + 2, mem);
            }
            mem[index] = num;
        } else {
            mem[index] = decode(s, index + 1, mem) + decode(s, index + 2, mem);
        }
        return mem[index];
    }
}
