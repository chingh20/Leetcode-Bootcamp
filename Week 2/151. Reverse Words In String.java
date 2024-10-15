import java.util.ArrayList;
import java.util.List;

class Solution {
    public String reverseWords(String s) {
        List<String> ls = new ArrayList<>();
        int index = 0;
        StringBuilder curr = new StringBuilder();
        while (index < s.length()) {
            if (s.charAt(index) != ' ') {
                curr.append(s.charAt(index));
            } else {
                String temp = curr.toString();
                if (curr.length() != 0) {
                    ls.add(temp);
                    curr = new StringBuilder();
                }
            }
            index++;
        }
        if (curr.length() != 0) {
            ls.add(curr.toString());
        }
        String sol = "";
        for (String t: ls) {
            sol = t + " " + sol;
        }
        return sol.substring(0, sol.length()-1);
    }
}