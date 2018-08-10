// https://leetcode.com/problems/non-decreasing-array/
class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                int tmp = nums[i];
                if (i == 0) {
                    nums[i] = Integer.MIN_VALUE;;
                } else {
                    nums[i] = nums[i - 1];
                }
                if (nums[i] > nums[i + 1]) {
                    nums[i] = tmp;
                    nums[i + 1] = nums[i];
                    if (nums[i] > nums[i + 1] || nums[i - 1] > nums[i]) return false;
                }
                
            }
        }
        
        return count <= 1;
    }
}
