// https://leetcode.com/problems/rle-iterator/
class RLEIterator {

    private int[] A;
    private int len;
    private int i = 0;
    
    public RLEIterator(int[] A) {
        this.A = A;
        len = A.length;
    }
    
    public int next(int n) {
        while (i < len) {
            if (n > A[i]) {
                n -= A[i];
                A[i] = 0;
                i += 2;
            } else {
                A[i] -= n;
                break;
            }
        }
        
        if (i >= len) {
            return -1;
        }
        
        return A[i + 1];
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */
