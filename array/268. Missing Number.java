// https://leetcode.com/problems/missing-number/
class Solution1 { // 8ms
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int last = 0;
        if (nums[0] != 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != last + 1) {
                return last + 1;
            }
            last = nums[i];
        }
        
        return nums.length;
    }
}

// checksum, by java 8 stream
class Solution2 { // 45ms
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = IntStream.of(nums).sum();
        return expectedSum - actualSum;
    }
}

// checksum, by foreach loop
class Solution3 { // 0ms
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        
        for (int i : nums) {
            actualSum += i;
        }
        
        return expectedSum - actualSum;
    }
}
