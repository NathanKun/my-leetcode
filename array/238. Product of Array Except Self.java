// https://leetcode.com/problems/product-of-array-except-self/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        final int len = nums.length;
        int[] res = new int[len];
        
        // left
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        
        // right
        // res[len - 1] is done
        for (int i = len - 2, right = nums[len - 1]; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        
        return res;
    }
}
