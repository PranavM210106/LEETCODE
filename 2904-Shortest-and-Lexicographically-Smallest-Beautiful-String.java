class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int totalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') totalOnes++;
        }
        if (totalOnes < k) return "";
        
        String best = null;
        int left = 0, ones = 0;
        
        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '1') ones++;
            
            // Shrink from left while it doesn't break the count of exactly k ones
            while (ones == k) {
                // free shrink: drop leading zeros
                while (s.charAt(left) == '0') {
                    left++;
                }
                // now window [left, right] has exactly k ones, and s.charAt(left) == '1'
                String candidate = s.substring(left, right + 1);
                if (best == null || candidate.length() < best.length()
                        || (candidate.length() == best.length() && candidate.compareTo(best) < 0)) {
                    best = candidate;
                }
                // move left past this '1' to look for the next window
                left++;
                ones--;
            }
        }
        
        return best == null ? "" : best;
    }
}