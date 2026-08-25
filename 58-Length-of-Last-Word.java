class Solution {
    public int lengthOfLastWord(String s) {

        int right = s.length() - 1;

        // skip trailing spaces
        while (right >= 0 && s.charAt(right) == ' ') {
            right--;
        }

        int left = right;

        // move left back until space or start
        while (left >= 0 && s.charAt(left) != ' ') {
            left--;
        }

        return right - left;
        
    }
}