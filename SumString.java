class Solution {
    public boolean isSumString(String s) {
        int n = s.length();
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; i + j < n; j++) {
                if (isValid(s, 0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean isValid(String s, int start, int len1, int len2) {
        int n = s.length();
        String s1 = s.substring(start, start + len1);
        String s2 = s.substring(start + len1, start + len1 + len2);
        if ((s1.startsWith("0") && s1.length() > 1) || (s2.startsWith("0") && s2.length() > 1)) return false;
        while (start + len1 + len2 < n) {
            String sum = addStrings(s1, s2);
            int sumLen = sum.length();
            if (start + len1 + len2 + sumLen > n) return false;
            String next = s.substring(start + len1 + len2, start + len1 + len2 + sumLen);
            if (!next.equals(sum)) return false;
            start += len1;
            len1 = len2;
            len2 = sumLen;
            s1 = s2;
            s2 = sum;
        }
        return true;
    }

    private String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry > 0) {
            int x = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = x + y + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }
}

