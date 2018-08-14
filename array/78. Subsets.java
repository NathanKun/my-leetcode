// https://leetcode.com/problems/subsets/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        
        for (int i = 0; i < Math.pow(2, nums.length); i++) {
            List<Integer> sol = new ArrayList();
            
            for (int bit = 0; bit < nums.length; bit++) {
                boolean on = ( i & (1 << bit) ) != 0;
                
                if (on) {
                    sol.add(nums[bit]);
                }
            }
            
            res.add(sol);
        }
            
        return res;
    }
}
