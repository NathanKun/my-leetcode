// https://leetcode.com/problems/beautiful-arrangement-ii/
class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        
        res[0] = 1;
        
        // diff variate part
        for (int diff = n - 1; diff >= n - k + 1; diff--) {
            res[n - diff] = res[n - diff - 1] + diff * ( ((n - 1 - diff) % 2 == 0) ? 1 : -1 );
        }
        
        // diff constant part
        for (int i = k, diff = (res[k - 1] <= ((double)n / 2)) ? 1 : -1; i < n; i++) {
            res[i] = res[i - 1] + diff;
        }
        
        return res;
    }
}
