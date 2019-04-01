// https://leetcode.com/problems/available-captures-for-rook/
class Solution {
    public int numRookCaptures(char[][] board) {
        int r = 0;
        int c = 0;
        boolean found = false;
        int res = 0;
        
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (board[x][y] == 'R') {
                    found = true;
                    r = x;
                    c = y;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        
        if (!found) {
            return 0;
        }
        
        for (int x = r - 1;x >= 0; x--) {
            if (board[x][c] == 'B') {
                break;
            } else if (board[x][c] == 'p') {
                res++;
                break;
            }
        }
        
        for (int x = r + 1;x < 8; x++) {
            if (board[x][c] == 'B') {
                break;
            } else if (board[x][c] == 'p') {
                res++;
                break;
            }
        }
        
        for (int y = c - 1; y >= 0; y--) {
            if (board[r][y] == 'B') {
                break;
            } else if (board[r][y] == 'p') {
                res++;
                break;
            }
        }
        
        for (int y = c + 1; y < 8; y++) {
            if (board[r][y] == 'B') {
                break;
            } else if (board[r][y] == 'p') {
                res++;
                break;
            }
        }
        
        return res;
    }
}
