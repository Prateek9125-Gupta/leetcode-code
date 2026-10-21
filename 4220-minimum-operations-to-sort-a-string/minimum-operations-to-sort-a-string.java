class Solution {
    public int minOperations(String s) {
        int n = s.length();

        boolean sorted = true;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
                break;
            }
        }
        if (sorted) return 0;

        if (n == 2) return -1;

        char first = s.charAt(0);
        char last = s.charAt(n - 1);

        char min = 'z', max = 'a';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c < min) min = c;
            if (c > max) max = c;
        }

        // Sort suffix or prefix directly
        if (first == min || last == max) return 1;

        // Worst case: max at front and min at back
        if (first == max && last == min) {
            int minCount = 0, maxCount = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == min) minCount++;
                if (c == max) maxCount++;
            }
            return (minCount == 1 && maxCount == 1) ? 3 : 2;
        }

        return 2;
    }
}