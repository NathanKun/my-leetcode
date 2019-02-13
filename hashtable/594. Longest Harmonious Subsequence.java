// https://leetcode.com/problems/longest-harmonious-subsequence/
class Solution { // 83 ms, 43.9 MB
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int res = 0;
        
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        for (int k : map.keySet()) {
            if (map.containsKey(k + 1)) {
                int sum = map.get(k) + map.get(k + 1);
                
                if (sum > res) {
                    res = sum;
                }
            }
        }
        
        return res;
    }
}
