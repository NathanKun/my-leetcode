// https://leetcode.com/problems/contains-duplicate-ii/
class Solution1 { // Time Limit Exceeded
    public boolean containsNearbyDuplicate(int[] nums, int k) {        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k; j++) {
                if (j < nums.length && nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        
        return false;
    }
}

class Solution2 { // 1325 ms
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }
        
        // clone and sort
        int[] copy = nums.clone();
        Arrays.sort(copy);
        
        int i = 1;
        int last = nums[0];
        
        while (i < nums.length) {
            // find if there are duplicate numbers
            if (nums[i] == last) {
                // if found, check if meet requirement
                if (check(nums, last, k)) {
                    return true;
                }
                
                // skip the same numbers
                do {
                    i++;
                } while (i < nums.length && nums[i] == last);
            } else {
                last = nums[i];
            }
        }
        
        return false;
    }
    
    private boolean check(int[] nums, int n, int k) {
        // loop through thie list to find the number
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n) {
                int j;
                // check the next k numbers
                for (j = i + 1; j < nums.length && j <= i + k; j++) {
                    if (nums[j] == n) {
                        return true;
                    }
                }
                // skip numbers checked
                i = j - 1;
            }
        }
        
        return false;
    }
}

class Solution3 { // 8ms
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet();
        
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]); // keep only last k elements in set 
            }
            
            // add the new element, and there are k + 1 element
            if (!set.add(nums[i])) { // if return false, means element already exists
                return true;
            }
        }
        
        return false;
    }
}
