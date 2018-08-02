// https://leetcode.com/problems/two-sum/
class Solution { // 3 ms
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int[] copy = nums.clone();
        Arrays.sort(copy);
        
        while (left < right) {
            if (copy[left] + copy[right] > target) {
                right--;
            } else if (copy[left] + copy[right] < target) {
                left++;
            } else {
                break;
            }
        }
        
        left = copy[left];
        right = copy[right];
        
        boolean leftFound = false, rightFound = false;
        
        for (int i = 0; i < nums.length; i++) {
            if (!leftFound && left == nums[i]) {
                left = i;
                leftFound = true;
            } else if (!rightFound && right == nums[i]) {
                right = i;
                rightFound = true;
            }
            
            if (leftFound && rightFound) {
                return new int[] { left, right };
            }
        }
        
        return new int[] { -1, -1 };
    }
}
