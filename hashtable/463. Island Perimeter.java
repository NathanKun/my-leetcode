// https://leetcode.com/problems/island-perimeter/
class Solution1 {
    public int islandPerimeter(int[][] grid) {
        final int iLen = grid.length;
        final int jLen = grid[0].length;
        
        if (iLen == 0 || jLen == 0) {
            return 0;
        }
        
        int res = 0;
        
        for (int i = 0; i < iLen; i++) {
            for (int j = 0; j < jLen; j++) {
                if (grid[i][j] == 1) {
                    res += countCell(grid, i, j);
                }
            }
        }
        
        return res;
    }
    
    private int countCell(int[][] grid, int i, int j) {
        int count = 0;
        if (i == 0) {
            count++;
        } else if (grid[i - 1][j] == 0) {
            count++;
        }
        
        if (i == grid.length - 1) {
            count++;
        } else if (grid[i + 1][j] == 0) {
            count++;
        }
        
        if (j == 0) {
            count++;
        } else if (grid[i][j - 1] == 0) {
            count++;
        }
        
        if (j == grid[0].length - 1) {
            count++;
        } else if (grid[i][j + 1] == 0) {
            count++;
        }
        
        return count;
    }
}

class Solution2 {
    public int islandPerimeter(int[][] grid) {
        final int iLen = grid.length;
        final int jLen = grid[0].length;
        
        if (iLen == 0 || jLen == 0) {
            return 0;
        }
        
        int res = 0;
        
        for (int i = 0; i < iLen; i++) {
            for (int j = 0; j < jLen; j++) {
                if (grid[i][j] == 1) {
                    res += countCell(grid, i, j);
                }
            }
        }
        
        return res;
    }
    
    private int countCell(int[][] grid, int i, int j) {
        int count = 4;
        
        if (i < grid.length - 1 && grid[i + 1][j] == 1) {
            count -=2;
        }
        
        if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
            count -=2;
        }
        
        return count;
    }
}
