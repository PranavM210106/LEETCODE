class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        
        int low = 0, high = m;
        while (low <= high) {
            int i = (low + high) / 2;
            int j = (m + n + 1) / 2 - i;

            // 1. declare first
            int nums1Left  = (i == 0) ? Integer.MIN_VALUE : nums1[i-1];
            int nums1Right = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int nums2Left  = (j == 0) ? Integer.MIN_VALUE : nums2[j-1];
            int nums2Right = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // 2. check valid partition
            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                if ((m + n) % 2 == 1) {
                    return Math.max(nums1Left, nums2Left);
                } else {
                    return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;
                }
            // 3. adjust
            } else if (nums1Left > nums2Right) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }
        return 0.0;
    }
}