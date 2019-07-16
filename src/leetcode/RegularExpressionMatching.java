package leetcode;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if (p.length() == 0){
            if (s.length() == 0){
                return true;
            } else {
                return false;
            }
        }

        int sIndex = 0, pIndex = 0;
        boolean init = false;
        boolean matchAll = false;
        boolean nextMatchAll = false;
        char matchC = '.';
        char nextMatchC = '.';
        while (true){
            if (pIndex == p.length()){
                if (sIndex == s.length()){
                    return true;
                } else {
                    if (matchAll){
                        if (matchC == '.'){
                            return true;
                        } else {
                            while (sIndex < s.length()){
                                if (s.charAt(sIndex) != matchC){
                                    return false;
                                }
                                return true;
                            }
                        }
                    } else {
                        return false;
                    }
                }
            }

            if (sIndex == s.length()){
                int restL = p.length() - pIndex;
                if (restL % 2 == 1){
                    return false;
                }

                for (int i = pIndex + 1;i < p.length();i += 2){
                    if (p.charAt(i) != '*'){
                        return false;
                    }
                }
                return true;
            }

            char c = p.charAt(pIndex);
            if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*'){
                nextMatchAll = true;
                nextMatchC = c;
            } else {
                nextMatchAll = false;
            }

//            if (!init){
//                matchAll = nextMatchAll;
//                matchC = nextMatchC;
//                init = true;
//            }

            if (nextMatchAll){
                p = p.substring(pIndex + 2);
                boolean flag = false;

                if (nextMatchC == '.'){
                    if (p.length() == 0){
                        return true;
                    }

                    while (sIndex < s.length()){
                        if (isMatch(s.substring(sIndex), p)){
                            flag = true;
                            break;
                        }
                        sIndex++;
                    }
                    if (flag){
                        return true;
                    } else {
                        return isMatch(s.substring(sIndex), p);
                    }
                } else {
                    while (sIndex < s.length() && s.charAt(sIndex) == nextMatchC){
                        if (isMatch(s.substring(sIndex), p)){
                            flag = true;
                            break;
                        }
                        sIndex++;
                    }
                    if (flag){
                        return true;
                    } else {
                        return isMatch(s.substring(sIndex), p);
                    }
                }
            }

            if (c >= 'a' && c <= 'z'){
                if(s.charAt(sIndex) != c){
                    if (!matchAll){
                        if (nextMatchAll){
                            matchAll = nextMatchAll;
                            matchC = nextMatchC;
                            pIndex += 2;
                        } else {
                            return false;
                        }
                    } else {
                        if (matchC == '.'){
                            return false;
                        } else {
                            while (sIndex < s.length() && s.charAt(sIndex) == matchC){
                                sIndex++;
                            }
                            if (sIndex >= s.length()){
                                return false;
                            } else {
                                if (s.charAt(sIndex) == c){
                                    sIndex++;
                                    pIndex++;
                                    if (nextMatchAll){
                                        pIndex++;
                                    }

                                    matchAll = nextMatchAll;
                                    matchC = nextMatchC;
                                } else {
                                    return false;
                                }
                            }
                        }
                    }
                } else {
                    sIndex++;
                    pIndex++;
                    if (nextMatchAll){
                        pIndex++;
                    }

                    matchAll = nextMatchAll;
                    matchC = nextMatchC;
                }
            } else {
                if (nextMatchAll){
                    p = p.substring(pIndex + 2);
                    if (p.length() == 0){
                        return true;
                    }

                    boolean flag = false;
                    while (sIndex < s.length()){
                        if (isMatch(s.substring(sIndex), p)){
                            flag = true;
                            break;
                        }
                        sIndex++;
                    }
                    return flag;
                } else {
                    if (matchAll) {
                        p = p.substring(pIndex);

                        boolean flag = false;
                        while (sIndex < s.length() && s.charAt(sIndex) == matchC) {
                            if (isMatch(s.substring(sIndex), p)) {
                                flag = true;
                                break;
                            }
                            sIndex++;
                        }
                        if (!flag && isMatch(s.substring(sIndex), p)) {
                            flag = true;
                        }
                        return flag;
                    } else {
                        sIndex++;
                        pIndex++;

                        matchAll = nextMatchAll;
                        matchC = nextMatchC;
                    }
                }
            }
        }
    }
}
