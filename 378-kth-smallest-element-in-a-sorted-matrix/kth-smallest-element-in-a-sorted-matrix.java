
class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;

        int st = matrix[0][0];
        int end = matrix[n - 1][n - 1];

        while (st < end) {

            int mid = st + (end - st) / 2;

            int count = 0;

            // Count elements <= mid
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] <= mid) {
                        count++;
                    }
                }
            }

            if (count < k) {
                st = mid + 1;
            } else {
                end = mid;
            }
        }

        return st;
    }
}
