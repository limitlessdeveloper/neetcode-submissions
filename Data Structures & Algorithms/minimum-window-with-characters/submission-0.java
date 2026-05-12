class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        for (char ch : t.toCharArray()) need.merge(ch, 1, Integer::sum);

        int have = 0, required = need.size(), left = 0;
        Map<Character, Integer> window = new HashMap<>();
        int[] result = {-1, 0, 0};

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.merge(c, 1, Integer::sum);

            if (need.containsKey(c) && window.get(c).equals(need.get(c))) {
                have++;
            }

            while (have == required) {
                if (result[0] == -1 || result[0] > right - left + 1) {
                    result[0] = right - left + 1;
                    result[1] = left;
                    result[2] = right;
                }

                char lc = s.charAt(left);
                window.merge(lc, -1, Integer::sum);
                if (window.get(lc) == 0) window.remove(lc);

                if (need.containsKey(lc) && 
                    (window.get(lc) == null || window.get(lc) < need.get(lc))) {
                    have--;
                }
                left++;
            }
        }
        return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
    }
}