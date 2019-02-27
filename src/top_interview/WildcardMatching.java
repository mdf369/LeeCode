package top_interview;

public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int indexS, indexP;
        indexS = indexP = 0;
        int preS, preP;
        preS = preP = 0;
        boolean back = false;

        while (indexS < s.length()) {
            if (indexP < p.length() && (p.charAt(indexP) == '?' || p.charAt(indexP) == s.charAt(indexS))) {
                indexP++;
                indexS++;
            } else if (indexP < p.length() && p.charAt(indexP) == '*') {
                while (indexP < p.length() && p.charAt(indexP) == '*') {
                    indexP++;
                }
                if (indexP == p.length()) {
                    return true;
                }

                back = true;
                preP = indexP;
                preS = indexS;
            } else if (back) {
                preS++;
                indexS = preS;
                indexP = preP;
            } else {
                return false;
            }
        }

        while (indexP < p.length() && p.charAt(indexP) == '*') {
            indexP++;
        }
        if (indexS == s.length() && indexP == p.length()) {
            return true;
        } else {
            return false;
        }
    }
}
