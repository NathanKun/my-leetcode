// https://leetcode.com/problems/squares-of-a-sorted-array/
class Solution {
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        
        int[] res = new int[A.length];
        int left = A.length - 1;
        int right = A.length;
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                A[i] = -1 * A[i];
            } else {
                left = i - 1;
                right = i;
                break;
            }
        }
        
        int i = 0;
        
        while (left >= 0 && right < A.length) {
            if (A[left] < A[right]) {
                res[i] = A[left] * A[left];
                left--;
            } else {
                res[i] = A[right] * A[right];
                right++;
            }
            
            i++;
        }
        
        while (left != -1) {
            res[i] = A[left] * A[left];
            left--;
            i++;
        }
        
        while (right != A.length) {
            res[i] = A[right] * A[right];
            right++;
            i++;
        }
        
        return res;
    }
}
