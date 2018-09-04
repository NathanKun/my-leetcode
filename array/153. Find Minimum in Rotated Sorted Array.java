// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
class Solution1 { // 1 ms
    public int findMin(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        
        return nums[0];
    }
}

class Solution2 { // 0 ms
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        int l = 0, r = nums.length - 1;
        
        while (l <= r) {
            if (nums[l] <= nums[r]) {
                return nums[l];
            }
            
            int m = (l + r) / 2;
            
            if (nums[m] >= nums[l]) { // when equals, means m == l && r == l + 1
                l = m + 1;
            } else {
                r = m;
            }
        }
        
        return -1;
    }
}
