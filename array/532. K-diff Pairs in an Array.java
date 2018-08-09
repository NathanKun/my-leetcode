// https://leetcode.com/problems/k-diff-pairs-in-an-array/
class Solution { // 14ms
    public int findPairs(int[] nums, int k) {
        if (nums.length < 2) {
            return 0;
        }
        if (k < 0) {
            return 0;
        }
        int count = 0;
        
        if (k != 0) {
            Set<Integer> set = new HashSet();
            for (int n : nums) {
                set.add(n);
            }
        
            for (int n : set) {
                if (set.contains(n + k)) {
                    count++;
                }
            }
        } else {
            Arrays.sort(nums);
            int i = 1;
            int last = nums[0];
            while (i < nums.length) {
                if (nums[i] == last) {
                    count++;
                    
                    do {
                        i++;
                    } while (i < nums.length && nums[i] == last);
                    if (i < nums.length) {
                        last = nums[i];
                    }
                } else {
                    last = nums[i];
                }
                i++;
            }
        }
        
        
        return count;
    }
}
