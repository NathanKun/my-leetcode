// https://leetcode.com/problems/sort-array-by-parity/
class Solution { // 16 ms, sort in place
    public int[] sortArrayByParity(int[] A) {
        final int len = A.length;
        
        if (len == 0 || len == 1) {
            return A;
        }
        
        int left = 0, right = len - 1;
        
        while (left < right) {
            if (A[left] % 2 == 1) {
                int tmp = A[left];
                
                while (left < right && A[right] % 2 == 1) {
                    right--;
                }
                
                if (left >= right) {
                    return A;
                }
                
                A[left] = A[right];
                A[right--] = tmp;
            }
            
            left++;
        }
        
        return A;
    }
}
