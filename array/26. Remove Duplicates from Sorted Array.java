// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
class Solution {
    public int removeDuplicates(int[] nums) {
        final int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return 1;
        }
        
        int slow = 1, fast = 1;
        int last = nums[0];
        
        while (fast < len) {
            if (nums[fast] == last) {
                while (fast < len && nums[fast] == last) {
                    fast++;
                }
                if (fast >= len) {
                    break;
                }
            }
            
            nums[slow] = nums[fast];
            last = nums[slow];
            fast++;
            slow++;
        }
        
        return slow;
    }
}
