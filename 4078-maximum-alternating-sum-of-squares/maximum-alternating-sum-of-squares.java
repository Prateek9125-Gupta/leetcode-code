import java.util.*;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] sq = new long[n];
        for (int i = 0; i < n; i++) {
            sq[i] = (long) nums[i] * nums[i];
        }
        Arrays.sort(sq);

        long ans = 0;
        int mid = n / 2; // number of subtracted elements
        for (int i = 0; i < n; i++) {
            if (i < mid) ans -= sq[i];
            else ans += sq[i];
        }
        return ans;
    }
}