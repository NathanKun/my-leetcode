// https://leetcode.com/problems/combination-sum/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        
        find(res, new ArrayList<Integer>(), candidates, target, 0);
        
        return res;
    }
    
    private void find(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int index) {
        if (target < 0) {
            return;
        }
        
        if (target == 0) {
            res.add(new ArrayList(list));
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            final int n = candidates[i];
            list.add(n);
            find(res, list, candidates, target - n, i);
            list.remove(list.size() - 1);
        }
    }
}
