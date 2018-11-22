// https://leetcode.com/problems/single-number/
class Solution1 { // 13 ms
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet();
        
        for (int n : nums) {
            if (set.contains(n)) {
                set.remove(n);
            } else {
                set.add(n);
            }
        }
        
        return set.iterator().next();
    }
}

class Solution2 { // 1 ms
    public int singleNumber(int[] nums) {
        int res = 0;
        
        for (int n : nums) {
            res ^= n;
        }
        
        return res;
    }
}
