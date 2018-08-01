// https://leetcode.com/problems/maximum-subarray/
class Solution1 { // 14ms
	public int maxSubArray(final int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            sum += nums[i];
            if (sum < 0) {
                sum = 0;
            } else {
                maxSum = Math.max(maxSum, sum);
            }
        }
        
        return max > maxSum ? max : maxSum;
	}
}

class Solution2 { // 8ms
	public int maxSubArray(final int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            sum += nums[i];
            if (sum < 0) {
                sum = 0;
            } else if (sum > maxSum) {
                maxSum = sum;
            }
        }
        
        return max > maxSum ? max : maxSum;
	}
}
