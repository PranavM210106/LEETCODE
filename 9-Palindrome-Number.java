class Solution {
    public boolean isPalindrome(int x) {
      
        if (x < 0) return false;

        char[] digits = Integer.toString(x).toCharArray();

        int left = 0, right = digits.length - 1;

        while (left < right) {
            if (digits[left] != digits[right]) return false;
            left++;
            right--;
        }

        return true;
    }
}