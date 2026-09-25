import java.util.*;

class Solution {

    int n;
    int k;

    class Node {
        int prod;
        int[] cnt;

        Node() {
            prod = 1 % k;
            cnt = new int[k];
        }
    }

    Node[] tree;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;

        tree = new Node[4 * n];

        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            // Persistent point update
            update(1, 0, n - 1, index, value);

            // Get information for nums[start ... n-1]
            Node result = query(1, 0, n - 1, start, n - 1);

            ans[q] = result.cnt[x];
        }

        return ans;
    }

    // ---------------------------------------------------------
    // Build
    // ---------------------------------------------------------

    private void build(int node, int left, int right, int[] nums) {

        if (left == right) {
            tree[node] = new Node();

            int rem = nums[left] % k;

            tree[node].prod = rem;

            // The single element itself is one non-empty prefix
            tree[node].cnt[rem] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid, nums);
        build(node * 2 + 1, mid + 1, right, nums);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    // ---------------------------------------------------------
    // Merge two adjacent segments
    // ---------------------------------------------------------

    private Node merge(Node A, Node B) {

        Node C = new Node();

        // Product of entire segment
        C.prod = (A.prod * B.prod) % k;

        // Prefixes completely inside A
        for (int r = 0; r < k; r++) {
            C.cnt[r] += A.cnt[r];
        }

        // Prefixes = all of A + prefix of B
        for (int r = 0; r < k; r++) {

            int newRem = (A.prod * r) % k;

            C.cnt[newRem] += B.cnt[r];
        }

        return C;
    }

    // ---------------------------------------------------------
    // Point Update
    // ---------------------------------------------------------

    private void update(int node, int left, int right,
                        int index, int value) {

        if (left == right) {

            tree[node] = new Node();

            int rem = value % k;

            tree[node].prod = rem;
            tree[node].cnt[rem] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, right, index, value);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    // ---------------------------------------------------------
    // Range Query
    // ---------------------------------------------------------

    private Node query(int node, int left, int right,
                       int ql, int qr) {

        // Completely inside range
        if (ql <= left && right <= qr) {
            return tree[node];
        }

        int mid = left + (right - left) / 2;

        // Entirely in right half
        if (qr <= mid) {
            return query(node * 2, left, mid, ql, qr);
        }

        // Entirely in left half
        if (ql > mid) {
            return query(node * 2 + 1, mid + 1, right, ql, qr);
        }

        // Crosses both halves
        Node A = query(node * 2, left, mid, ql, qr);
        Node B = query(node * 2 + 1, mid + 1, right, ql, qr);

        return merge(A, B);
    }
}