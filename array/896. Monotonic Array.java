// https://leetcode.com/problems/monotonic-array/
class Solution {
    public boolean isMonotonic(int[] A) {
        if (A.length <= 2) {
            return true;
        }

        int i = 1;
        while (i < A.length && A[i] == A[i - 1]) {
            i++;
        }
        
        if (i == A.length) {
            return true;
        }
        
        boolean inc = A[i] >= A[i - 1];
        
        
        while (i < A.length) {
            if (A[i] > A[i - 1] ^ inc && A[i] != A[i - 1]) {
                return false;
            }
            
            i++;
        }
        
        return true;
    }
}
