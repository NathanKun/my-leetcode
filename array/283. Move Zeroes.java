// https://leetcode.com/problems/move-zeroes/
class Solution {
    public void moveZeroes(int[] nums) {
        int max = nums.length;
        int i = 0,  j = 0;
        
        while (i < max) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
            i++;
        }
        
        while (j < max) {
            nums[j++] = 0;
        }
    }
}

class Solution2 {
    public void moveZeroes(int[] nums) {
        int zeroCount = 0;
        int max = nums.length;
        int i = 0;
        
        while (i + zeroCount < max) {
            if (nums[i + zeroCount] == 0) {
                do {
                    zeroCount++;
                } while (i + zeroCount < max && nums[i + zeroCount] == 0);
            }
            
            if (i + zeroCount < max) {
                nums[i] = nums[i + zeroCount];
            }
            i++;
        }
        
        i = nums.length - zeroCount;
        while (i < nums.length) {
            nums[i] = 0;
            i++;
        }
    }
}
