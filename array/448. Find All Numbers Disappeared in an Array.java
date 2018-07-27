// https://leetcode.com/submissions/detail/166151969/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int[] array = new int[nums.length];
        
        for (int n : nums) {
            array[n - 1] = 1;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (array[i] == 0) {
                res.add(i + 1);
            }
        }
        
        return res;
    }
}
