// https://leetcode.com/problems/pascals-triangle/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList();
        if (numRows == 0) {
            return res;
        }
        
        List<Integer> lastCol = Arrays.asList(1);
        res.add(lastCol);
        
        for (int r = 2; r <= numRows; r++) { // r is 1 based
            List<Integer> col = new ArrayList();
            col.add(1);
            
            for (int c = 2; c < r; c++) { // c is 1 based
                col.add(lastCol.get(c - 2) + lastCol.get(c - 1));
            }
            
            col.add(1);
            res.add(col);
            lastCol = col;
        }
        
        return res;
    }
}
