// https://leetcode.com/problems/sort-colors/
class Solution {
    public void sortColors(int[] nums) {
        int iZero = 0, iTwo = nums.length - 1;
        
        for (int i = 0; i <= iTwo; i++) {
            if (nums[i] == 0 && i != iZero) {
                nums[i--] = nums[iZero];
                nums[iZero++] = 0;
            } else if (nums[i] == 2 && i != iTwo) {
                nums[i--] = nums[iTwo];
                nums[iTwo--] = 2;
            }
        }
    }
}
