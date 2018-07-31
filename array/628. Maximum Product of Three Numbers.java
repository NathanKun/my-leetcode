// https://leetcode.com/problems/maximum-product-of-three-numbers/
class Solution1 { // 20 ms
    public int maximumProduct(int[] nums) {
        final int len = nums.length;
        Arrays.sort(nums);
        
        if (nums[len - 1] == 0) {
            return 0;
        } if (nums[len - 1] < 0) {
            return nums[len - 1] * nums[len - 2] * nums[len - 3];
        } else if (nums[0] * nums[1] > nums[len - 2] * nums[len - 3]) {
            return nums[0] * nums[1] * nums[len - 1];
        } else {
            return nums[len - 3] * nums[len - 2] * nums[len - 1];
        }
    }
}

class Solution2 { // 20ms
    public int maximumProduct(int[] nums) {
        final int len = nums.length;
        Arrays.sort(nums);
        
        int max1 = nums[len - 1];
        int max2 = nums[len - 2];
        int max3 = nums[len - 3];
        int min1 = nums[1];
        int min2 = nums[0];
        
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}

class Solution { // 7ms
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }
            
            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}
