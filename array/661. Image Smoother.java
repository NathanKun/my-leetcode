// https://leetcode.com/problems/image-smoother/
class Solution1 { // 16ms
    public int[][] imageSmoother(int[][] M) {
        final int rMax = M.length;
        final int cMax = M[0].length;
        
        int[][] out = new int[rMax][cMax];
        
        for (int r = 0; r < rMax; r++) {
            for (int c = 0; c < cMax; c++) {
                int count = 1;
                int sum = M[r][c];
                if (c != 0) {
                    sum += M[r][c - 1];
                    count ++;
                }
                if (c != cMax - 1) {
                    sum += M[r][c + 1];
                    count ++;
                }
                
                if (r != 0) {
                    sum += M[r - 1][c];
                    count ++;
                    if (c != 0) {
                        sum += M[r - 1][c - 1];
                        count ++;
                    }
                    if (c != cMax - 1) {
                        sum += M[r - 1][c + 1];
                        count ++;
                    }
                }
                
                if (r != rMax - 1) {
                    sum += M[r + 1][c];
                    count ++;
                    if (c != 0) {
                        sum += M[r + 1][c - 1];
                        count ++;
                    }
                    if (c != cMax - 1) {
                        sum += M[r + 1][c + 1];
                        count ++;
                    }
                }
                
                out[r][c] = sum / count;
            }
        }
        
        return out;
    }
}

class Solution2 { // 13ms
    public int[][] imageSmoother(int[][] M) {
        if(M == null || M.length == 0 || M[0] == null || M[0].length == 0) return M;
        
        final int rMax = M.length;
        final int cMax = M[0].length;
        
        int[][] out = new int[rMax][cMax];
        
        for (int r = 0; r < rMax; r++) {
            for (int c = 0; c < cMax; c++) {
                out[r][c] = avg(r, c, rMax, cMax, M);
            }
        }
        
        return out;
    }
    
    private int avg(int r, int c, int rMax, int cMax, int[][] m) {
        int count = 0;
        int sum = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int x = r + i;
                int y = c + j;
                if (x < 0 || x >= rMax || y < 0 || y >= cMax) {
                    continue;
                }
                sum += m[x][y];
                count++;
            }
        }

        return sum / count;
    }
}
