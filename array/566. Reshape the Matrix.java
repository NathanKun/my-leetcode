// https://leetcode.com/problems/reshape-the-matrix/
class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        final int numsColLen = nums[0].length;
        
        // check if reshapable
        if (nums.length * numsColLen != r * c) {
            return nums;
        }
        
        int rNums = 0, cNums = 0;
        int[][] res = new int[r][c];
        for (int ir = 0; ir < r; ir++) {
            for (int ic = 0; ic < c; ic++) {
                res[ir][ic] = nums[rNums][cNums];
                cNums++;
                if (cNums == numsColLen) {
                    cNums = 0;
                    rNums++;
                }
            }
        }
        
        return res;
    }
}
