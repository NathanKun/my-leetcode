// https://leetcode.com/problems/set-mismatch/
class Solution { // 4 ms, 40.9 MB
    public int[] findErrorNums(int[] nums) {
        int[] set = new int[nums.length + 1];
        
        for (int n : nums) {
            set[n]++;
        }
        
        int duplicate = 0;
        int missing = 0;
        
        for (int i = 1; i < set.length; i++) {
            int n = set[i];
            
            if (n == 0) {
                missing = i;
            } else if (n == 2) {
                duplicate = i;
            }
        }
        
        return new int[] {duplicate, missing};
    }
}
