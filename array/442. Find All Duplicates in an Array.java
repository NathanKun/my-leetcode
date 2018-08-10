// https://leetcode.com/problems/find-all-duplicates-in-an-array/
class Solution { // 28ms
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList();
        Set<Integer> set = new HashSet();
        
        for (int n : nums) {
            if (!set.add(n)) {
                res.add(n);
            }
        }
        
        return res;
    }
}

class Solution { // 9ms
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList();
        // 1 ≤ a[i] ≤ n
        int[] array = new int[nums.length + 1];
        
        for (int n : nums) {
            array[n]++;
        }
        
        for (int i = 0; i < nums.length + 1; i++) {
            if (array[i] == 2) {
                res.add(i);
            }
        }
        
        return res;
    }
}
