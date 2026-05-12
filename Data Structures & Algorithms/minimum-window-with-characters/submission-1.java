class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] need = new int[128];
        int required = 0;
        for (char ch : t.toCharArray()) {
            if (need[ch]++ == 0) required++;
        }

        int[] window = new int[128];
        int have = 0, left = 0;
        int bestLen = Integer.MAX_VALUE, bestLeft = 0;

        char[] arr = s.toCharArray();  // avoid charAt() bounds checks

        for (int right = 0; right < arr.length; right++) {
            char c = arr[right];
            if (++window[c] == need[c]) have++;

            while (have == required) {
                int windowLen = right - left + 1;
                if (windowLen < bestLen) {
                    bestLen = windowLen;
                    bestLeft = left;
                }

                char lc = arr[left++];
                if (window[lc]-- == need[lc]) have--;
            }
        }

        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestLeft, bestLeft + bestLen);
    }
}