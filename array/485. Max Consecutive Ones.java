// https://leetcode.com/problems/max-consecutive-ones/
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, maxCount = 0;
        
        for (int i : nums) {
            if (i == 1) {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                }
                count = 0;
            }
        }
        
        if (count > maxCount) {
            maxCount = count;
        }
        
        return maxCount;
    }
}
