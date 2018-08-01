class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        
        int count = 1;
        int max = 1;
        int last = nums[0];
        
        for (int i = 1; i < len; i++) {
            if (nums[i] > last) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
            last = nums[i];
        }
        
        max = Math.max(max, count);
        return max;
    }
}
