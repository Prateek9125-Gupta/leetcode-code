class Solution {
    public String getPermutation(int n, int k) {
        java.util.List<Integer> numbers = new java.util.ArrayList<>();

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        int fact = 1;
        for (int i = 1; i < n; i++) {
            fact *= i;
        }
        k--;

        StringBuilder ans = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            int index = k / fact;
            ans.append(numbers.get(index));
            numbers.remove(index);
            k = k % fact;
            if (i > 0) {
                fact = fact / i;
            }
        }

        return ans.toString();
    }
}