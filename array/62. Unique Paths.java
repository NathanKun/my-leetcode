// https://leetcode.com/problems/unique-paths/
class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) {
            return 0;
        }
        
        if(m == 1 || n == 1) {
            return 1;
        }
        
        int[][] map = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            map[i][n - 1] = 1;
        }
        
        for (int i = 0; i < n; i++) {
            map[m - 1][i] = 1;
        }
        
        for (int r = m - 2; r >= 0; r--) {
            for (int c = n - 2; c >= 0; c--) {
                map[r][c] = map[r][c + 1] + map[r + 1][c];
            }
        }
        
        return map[0][0];
    }
}
