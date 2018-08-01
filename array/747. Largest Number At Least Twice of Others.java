// https://leetcode.com/problems/largest-number-at-least-twice-of-others/
class Solution {
    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        
        int max1 = nums[0], max2 = Integer.MIN_VALUE;
        int iMax1 = 0;
        
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            if (n > max1) {
                iMax1 = i;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max2 = n;
            }
        }
        
        if (max2 * 2 <= max1) {
            return iMax1;
        }
        return -1;
    }
}
