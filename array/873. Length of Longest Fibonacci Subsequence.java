// https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
class Solution {
    public int lenLongestFibSubseq(int[] A) {
        final int len = A.length;
        
        int[][] dp = new int[len][len];
        Map<Integer, Integer> index = new HashMap();
        int res = 0;
        
        for (int i = 0; i < len; i++){
            index.put(A[i], i);
            for (int j = 0; j < len; j++) {
                dp[i][j] = 2;
            }
        }
        
        for (int iNum3 = 0; iNum3 < len; iNum3++){
            for (int iNum2 = 0; iNum2 < iNum3; iNum2++) {
                int num1 = A[iNum3] - A[iNum2];
                if (index.containsKey(num1)) {
                    int iNum1 = index.get(num1);
                    
                    if(num1 < A[iNum2]) {
                        dp[iNum2][iNum3] = dp[iNum1][iNum2] + 1;
                        res = Math.max(res, dp[iNum2][iNum3]);
                    }
                }
            }
        }
        
        return res == 2 ? 0 : res;
    }
}
