// https://leetcode.com/problems/find-pivot-index/
class Solution {
    public int pivotIndex(int[] nums) {
        final int len = nums.length;
        int left = 0, right = 0;
        
        for (int n : nums) {
            right += n;
        }
        
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            right -= val;
            
            if (left == right) {
                return i;
            }
            
            left += val;
        }
        
        return -1;
    }
}
