// https://leetcode.com/problems/positions-of-large-groups/
class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (S == null || S.length() < 3) {
            return res;
        }
        
        char[] array = S.toCharArray();
        
        char current = array[0];
        int start = 0;
        int end = 0;
        
        for (int i = 1; i < array.length; i++) {
            if (array[i] != current) {
                end = i - 1;
                if (end - start >= 2) {
                    res.add(Arrays.asList(start, end));
                }
                
                start = i;
                current = array[i];
            }
        }
        
        end = array.length - 1;
        if (end - start >= 2) {
            res.add(Arrays.asList(start, end));
        }
        
        return res;
    }
}
