// https://leetcode.com/problems/maximum-average-subarray-i/
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        final int len = nums.length;
        
        if (len == 1) {
            return nums[0];
        }
        
        int i;
        int sum = 0;
        for (i = 0; i < k; i++) {
            sum += nums[i];
        }
        
        double max = sum;
        
        for (i = k; i < len; i++) {
            sum = sum + nums[i] - nums[i - k];
            if (sum > max) {
                max = sum;
            }
        }
        
        return max / k;
    }
}
