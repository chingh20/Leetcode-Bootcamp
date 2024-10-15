import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int pLength = p.length();
        int left = 0;
        int right = 0;
        int[] pDict = new int[26];
        for (char c: p.toCharArray()) {
            int index = c - 'a';
            pDict[index]++;
        }
        List<Integer> sol = new ArrayList<Integer>();
        int[] sDict = new int[26];
        int correct = 0;
        while (right < s.length()) {
            int index = s.charAt(right) - 'a';
            if (pDict[index] == 0) {
                right++;
                left = right;
                sDict = new int[26];
                correct = 0;
            }
            else if (pDict[index] == sDict[index]) {
                while (s.charAt(left) - 'a' != index) {
                    int i = s.charAt(left) - 'a';
                    if (sDict[i] > 0) {
                        sDict[i]--;
                        correct--;
                    }
                    left++;
                }
                left++;
                right++;
                if (correct == pLength) {
                    sol.add(left);
                    int i = s.charAt(left) - 'a';
                    sDict[i]--;
                    left++;
                    correct--;
                }
            } else if (pDict[index] > sDict[index]) {
                sDict[index]++;
                correct++;

                if (correct == pLength) {
                    sol.add(left);
                    int i = s.charAt(left) - 'a';
                    sDict[i]--;
                    left++;
                    correct--;
                }

                right++;
            }
        }
        return sol;
    }
}