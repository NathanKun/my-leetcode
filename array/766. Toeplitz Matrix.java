// https://leetcode.com/problems/toeplitz-matrix/
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        final int rMax = matrix.length - 1;
        final int cMax = matrix[0].length - 1;
        
        for (int r = 0; r < rMax; r++) {
            for (int c = 0; c < cMax; c++) {
                if (matrix[r][c] != matrix[r + 1][c + 1]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
