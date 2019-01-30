package top_interview;

public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        int index1, index2;
        index1 = index2 = 0;

        while (index1 < s.length() && index2 < p.length()){
            char c = p.charAt(index2);

            if (c == '*'){
                String newP = p.substring(index2 + 1);
                for (int i = index1;i <= s.length();i++){
                    if (isMatch(s.substring(i), newP)){
                        return true;
                    }
                }
                return false;
            } else if (c == '?'){

            } else {
                if (c != s.charAt(index1)){
                    return false;
                }
            }

            index1++;
            index2++;
        }

        if (index1 == s.length()){
            if (index2 == p.length()){
                return true;
            }

            for (int i = index2;i < p.length();i++){
                if (p.charAt(i) != '*'){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
