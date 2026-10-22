class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        // Check ascending rotation
        int k = nums[0];
        boolean asc = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] != (k + i) % n) { asc = false; break; }
        }
        if (asc) {
            if (k == 0) return 0;
            return Math.min(n - k, k + 2);
        }

        // Check descending rotation
        int d = nums[0];
        boolean desc = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] != ((d - i) % n + n) % n) { desc = false; break; }
        }
        if (desc) {
            if (d == n - 1) return 1;
            return Math.min(d + 2, n - d);
        }

        return -1;
    }
}