import java.util.*;

class ExactlyOneSwap {
    long countStrings(String s) {
        int n = s.length();
        Map<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += (n - mp.get(s.charAt(i)));
        }
        res /= 2;
        for (int val : mp.values()) {
            if (val >= 2) {
                res++;
                break;
            }
        }
        return res;
    }
}
