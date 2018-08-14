// https://leetcode.com/problems/combination-sum-iii/
class Solution1 { // 191 ms
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList(); 
        List<Set<Integer>> sets = new ArrayList();
        
        // find all possible set
        find(sets, new HashSet<Integer>(), 0, 0, k, n);
        
        // convert set to list
        for (Set<Integer> set : sets) {
            List<Integer> sol = new ArrayList();
            for (int num : set) {
                sol.add(num);
            }
            res.add(sol);
        }
        
        return res;
    }
    
    private void find(List<Set<Integer>> res, Set<Integer> used, int sum, int count, int k, int n) {
        if (count == k - 1) {
            int rest = n - sum;
            if (rest > 0 && rest <=9 && !used.contains(rest)) {
                Set<Integer> sol = new HashSet();
                for (int num : used) {
                    sol.add(num);
                }
                sol.add(rest);
                
                // check if already found this solution set
                boolean has = false;
                for (Set<Integer> s : res) {
                    if (s.equals(sol)) {
                        has = true;
                        break;
                    }
                }
                if (!has) {
                    res.add(sol);
                }
            }
        } else {
            // recursive
            for (int i = 1; i < Math.min(n - sum, 9); i++) {
                if (!used.contains(i)) {
                    Set<Integer> newUsed = new HashSet();
                    for (int num : used) {
                        newUsed.add(num);
                    }
                    newUsed.add(i);
                    find(res, newUsed, sum + i, count + 1, k, n);
                }
            }
        }
    }
}

class Solution2 { // 1ms
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList(); 
        
        find(res, new ArrayList<Integer>(), 0, n, 0, k);
        
        return res;
    }
    
    private void find(List<List<Integer>> res, List<Integer> used, int currentNum, int rest, int count, int k) {
        if (count == k) {
            if (rest == 0) {
                res.add(new ArrayList<Integer>(used));
            }
            return;
        }
        
        if (rest < 0) {
            return;
        }
            
        // recursive
        for (int i = currentNum + 1; i <= Math.min(rest, 9); i++) { // from currentNum to 9, to prevent using duplicate numbers
            used.add(i);

            find(res, used, i, rest - i, count + 1, k);

            used.remove(used.size() - 1);
        }
    }
}
