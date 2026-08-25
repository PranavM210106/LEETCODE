class Solution {
    public int[] twoSum(int[] nums, int target) {
        
    int n = nums.length;

    // Create pairs of (value, original_index)
    int[][] pairs = new int[n][2];
    for (int i = 0; i < n; i++) {
        pairs[i][0] = nums[i];  // value
        pairs[i][1] = i;         // original index
    }

    // Sort by value
    Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

    int left = 0, right = n - 1;

    while (left < right) {
        int sum = pairs[left][0] + pairs[right][0];
        if (sum == target) {
            return new int[] { pairs[left][1], pairs[right][1] };
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }

    return new int[] {}; 

    }
}