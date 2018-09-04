// https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/
// sol: https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/discuss/117612/C++-O(n)-solution-with-explanations
class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int res = 0;
        int heads = 0, tails = 0;
        
        for (int n : A) {
            if (n >= L && n <= R) {
                heads += 1 + tails;
                tails = 0;
                res += heads;
            } else if (n < L) {
                tails++;
                res += heads;
            } else { // n > R
                heads = 0;
                tails = 0;
            }
        }
        
        return res;
    }
}
