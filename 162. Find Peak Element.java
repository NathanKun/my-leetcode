// https://leetcode.com/problems/find-peak-element/
class Solution {
    public int findPeakElement(int[] nums) {
        final int len = nums.length;
        if (len == 0) {
            return -1;
        }
        
        return binSearch(nums, 0, len - 1);
    }
    
    private int binSearch(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }
        
        int m = (r - l) / 2 + l;
        if (nums[m] > nums[m + 1]) {
            return binSearch(nums, l, m);
        } else {
            return binSearch(nums, m + 1, r);
        }
    }
}
