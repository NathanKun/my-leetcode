// https://leetcode.com/problems/majority-element/
// Boyer-Moore Voting Algorithm
class Solution {
    public int majorityElement(int[] nums) {    
        int counter = 1;
        int maj = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == maj) {
                counter++;
            } else {
                counter--;
            }
            
            if (counter < 0) {
                counter = 1;
                maj = nums[i];
            }
        }
        
        return maj;
    }
}
