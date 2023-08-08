package mybatis;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {

        minWindow("ADOBECODEBANC", "ABC");
    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] need = new int[128];
        int needCh = t.length();
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        int result = Integer.MAX_VALUE;
        String str = "";
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            int times = need[s.charAt(i)];
            need[s.charAt(i)]--;
            if (times > 0) {
                needCh--;
            }
            while (needCh == 0) {
                int ans = need[s.charAt(left)]++;
                if (ans > 0) {
                    needCh++;
                    if (i - left + 1 < result) {
                        str = s.substring(left, i + 1);
                        result = i - left + 1;
                    }
                }
                left++;
            }
        }
        return str;
    }
}
