// https://leetcode.com/problems/rotate-array

// O(n) extra space
class Solution1 { // 0ms 
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] copy = nums.clone();
        
        for (int i = 0; i < nums.length; i++) {
            if (i - k >= 0) {
                nums[i] = copy[i - k];
            } else {
                nums[i] = copy[i - k + nums.length];
            }
        }
    }
}

// O(1) extra space
class Solution2 { // 0ms
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        
        int count = 0, i = 0, tmp1, tmp2 = 0, target;

        int minCommonMultiple = minCommonMultiple(nums.length, k);
        int cycleStep, cycleMax, cycle = 1;
        cycleStep = minCommonMultiple / k;
        cycleMax = nums.length / cycleStep;
        cycleStep++;
        
        
        while (cycle <= cycleMax) {
            i = cycle;
            count = 0;
            while (count <= cycleStep) {
                target = (i + k) >= nums.length ? (i + k - nums.length) : (i + k);

                tmp1 = nums[target];
                if (count != 0) {
                    nums[target] = tmp2;
                }                
                tmp2 = tmp1;

                i = target;
                count++;
            }
            cycle++;
        }
    }
    
    private int maxCommonDivider(int m, int n) {
        // make sure m > n
        if (m < n) {
            int tmp = m;
            m = n;
            n = tmp;
        }
        
        if (m % n == 0) {
            return n;
        } else {
            return maxCommonDivider(n, m % n);
        }
    }
    
    private int minCommonMultiple(int m, int n) {
        return m * n / maxCommonDivider(m, n);
    }
}
