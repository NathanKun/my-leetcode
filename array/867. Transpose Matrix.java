class Solution {
    public int[][] transpose(int[][] A) {
        int[][] res = new int[A[0].length][A.length];
        
        for (int r = 0; r < A[0].length; r++) {
            for (int c = 0; c < A.length; c++) {
                res[r][c] = A[c][r];
            }
        }
        
        return res;
    }
}
