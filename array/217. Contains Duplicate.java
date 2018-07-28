// https://leetcode.com/problems/contains-duplicate/
class Solution1 { // Time Limit Exceeded
    public boolean containsDuplicate(int[] nums) {
        List<Integer> list = new ArrayList();
        for (int n : nums){
            if (list.contains(n)) {
                return true;
            } else {
                list.add(n);
            }
        }
        return false;
    }
}
class Solution2 {  // 322 ms
    public boolean containsDuplicate(int[] nums) {
        final int len = nums.length;
        
        if (len == 1) {
            return false;
        }
        
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        
        return false;
    }
}

class Solution3 { // 10ms
    public boolean containsDuplicate(int[] nums) {
        final int len = nums.length;
        HashSet<Integer> set = new HashSet();
        
        for (int n : nums) {
            if (set.contains(n)) {
                return true;
            } else {
                set.add(n);
            }
        }
        
        return false;
    }
}
