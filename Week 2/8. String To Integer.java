class Solution {
    public int myAtoi(String s) {
        int i = 0;
        while(i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i == s.length()) {
            return 0;
        }
        int sign = 1;
        if (s.charAt(i) == '+') {
            i++;
        } else if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        int num = 0;
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int digit = s.charAt(i) - '0';
            int limit = (int)Math.pow(2, 30) + (int)(Math.pow(2, 30) - 1);
            if (sign == 1) {
                if (num > (limit - digit) / 10) {
                    num = limit;
                    break;
                }
                num = num * 10 + digit;
            } else {
                if (num > (limit - digit) / 10) {
                    num = (int)Math.pow(-2, 31);
                    break;
                }
                num = num * 10 + digit;
            }
            i++;
        }
        if (sign == -1) {
            return num * -1;
        }
        return num;

    }
}