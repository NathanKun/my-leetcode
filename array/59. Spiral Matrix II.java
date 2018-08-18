// https://leetcode.com/problems/spiral-matrix-ii/
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n == 0) {
            return res;
        }
        
        int num = 1;
        int r = 0, c = 0;
        
        res[r][c] = num;
        
        while (num != n * n) {
            num++;
            
            if (shouldGoRight(res, n, r, c)) {
                c++;
            } else if (shouldGoDown(res, n, r, c)) {
                r++;
            } else if (shouldGoLeft(res, n, r, c)) {
                c--;
            } else if (shouldGoUp(res, n, r, c)) {
                r--;
            } else {
                break;
            }
            
            res[r][c] = num;
        }
        
        return res;
    }
    
    private boolean shouldGoRight(int[][] res, int n, int r, int c) {
        return c + 1 < n && res[r][c + 1] == 0 && (r - 1 < 0 || res[r - 1][c] != 0);
    }
    
    private boolean shouldGoDown(int[][] res, int n, int r, int c) {
        return r + 1 < n && res[r + 1][c] == 0 && (c + 1 >= n || res[r][c + 1] != 0);
    }
    
    private boolean shouldGoLeft(int[][] res, int n, int r, int c) {
        return c - 1 >= 0 && res[r][c - 1] == 0 && (r + 1 >= n || res[r + 1][c] != 0);
    }
    
    private boolean shouldGoUp(int[][] res, int n, int r, int c) {
        return r - 1 >= 0 && res[r - 1][c] == 0 && (c - 1 < 0 || res[r][c - 1] != 0);
    }
}
