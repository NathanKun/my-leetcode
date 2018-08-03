// https://leetcode.com/problems/magic-squares-in-grid/
class Solution 1 { // 6ms
    public int numMagicSquaresInside(int[][] grid) {
        final int rLen = grid.length;
        final int cLen = grid[0].length;
        
        if (rLen < 3 || cLen < 3) {
            return 0;
        }
        
        int count = 0;
        
        for (int r = 0; r <= rLen - 3; r++) {
            for (int c = 0; c <= cLen - 3; c++) {
                if (isMagicSquare(grid, r, c)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private boolean isMagicSquare(int[][] grid, int r, int c) {
        HashSet<Integer> digits = new HashSet();
        
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int val = grid[i][j];
                if (val > 9 || val < 1 || digits.contains(val)) {
                    return false;
                } else {
                    digits.add(val);
                }
            }
        }
        
        int sum =  grid[r]    [c]     + grid[r]    [c + 1] + grid[r]    [c + 2];
        if (sum != grid[r + 1][c]     + grid[r + 1][c + 1] + grid[r + 1][c + 2] ||
            sum != grid[r + 2][c]     + grid[r + 2][c + 1] + grid[r + 2][c + 2] ||
            sum != grid[r]    [c]     + grid[r + 1][c]     + grid[r + 2][c]     ||
            sum != grid[r]    [c + 1] + grid[r + 1][c + 1] + grid[r + 2][c + 1] ||
            sum != grid[r]    [c + 2] + grid[r + 1][c + 2] + grid[r + 2][c + 2] ||
            sum != grid[r]    [c]     + grid[r + 1][c + 1] + grid[r + 2][c + 2] ||
            sum != grid[r]    [c + 2] + grid[r + 1][c + 1] + grid[r + 2][c]) {
            return false;
        }
        
        return true;
    }
}

class Solution2 { // 5ms
    public int numMagicSquaresInside(int[][] grid) {
        final int rLen = grid.length;
        final int cLen = grid[0].length;
        
        if (rLen < 3 || cLen < 3) {
            return 0;
        }
        
        int count = 0;
        
        for (int r = 0; r <= rLen - 3; r++) {
            for (int c = 0; c <= cLen - 3; c++) {
                if (isMagicSquare(grid[r][c], grid[r][c + 1], grid[r][c + 2],
                                 grid[r + 1][c], grid[r + 1][c + 1], grid[r + 1][c + 2],
                                 grid[r + 2][c], grid[r + 2][c + 1], grid[r + 2][c + 2])) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private boolean isMagicSquare(int rc, int rc1, int rc2, int r1c, int r1c1, int r1c2, int r2c, int r2c1, int r2c2) {
        if (r1c1 != 5) {
            return false;
        }
        
        int[] digits = new int[16];
        digits[rc]++;
        digits[r1c]++;
        digits[r2c]++;
        digits[rc1]++;
        digits[r1c1]++;
        digits[r2c1]++;
        digits[rc2]++;
        digits[r1c2]++;
        digits[r2c2]++;
        
        if (digits[1] != 1 || digits[2] != 1 || digits[3] != 1 || 
           digits[4] != 1 || digits[6] != 1 || 
           digits[7] != 1 || digits[8] != 1 || digits[9] != 1) {
            return false;
        }
        
        if (15 != rc + rc1 + rc2 ||
            10 != r1c + r1c2 ||
            15 != r2c + r2c1 + r2c2 ||
            15 != rc + r1c + r2c ||
            10 != rc1 + r2c1 ||
            15 != rc2 + r1c2 + r2c2 ||
            10 != rc + r2c2 ||
            10 != rc2 + r2c) {
            return false;
        }
        
        return true;
    }
}
