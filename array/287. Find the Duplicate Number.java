// https://leetcode.com/problems/find-the-duplicate-number/
class Solution {
    public int findDuplicate(int[] nums) {
        // increase O(nlogn) time complexity and no space complexity because Arrays.sort sort in-place
        Arrays.sort(nums);
        
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == last) {
                return last;
            }
            last = nums[i];
        }
        
        return -1;
    }
}
