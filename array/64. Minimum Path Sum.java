// https://leetcode.com/problems/minimum-path-sum/
class Solution { // 5 ms
    public int minPathSum(int[][] grid) {
        final int m = grid.length;
        if (m == 0) {
            return 0;
        }
        final int n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int sum = grid[r][c];
                if (r != 0 && c != 0) {
                    sum += Math.min(grid[r - 1][c], grid[r][c - 1]);
                } else if (r != 0) {
                    sum += grid[r - 1][c];
                } else if (c != 0) {
                    sum += grid[r][c - 1];
                } // else r=0 c=0, ignore
                
                grid[r][c] = sum;
            }
        }
        
        return grid[m - 1][n - 1];
    }
}
