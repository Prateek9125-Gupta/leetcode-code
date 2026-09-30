class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        java.util.Arrays.fill(ans, -1);

        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            int index = i % n;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
                ans[stack.pop()] = nums[index];
            }
            if (i < n) {
                stack.push(index);
            }
        }

        return ans;
    }
}