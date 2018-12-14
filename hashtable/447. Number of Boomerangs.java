// https://leetcode.com/problems/number-of-boomerangs/
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) { // all possible distances for i
                if (i == j) {
                    continue;
                }
                
                final int d = dist(points[i], points[j]);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
            
            for(int val : map.values()) { // permutations
                res += val * (val-1);
            }            
            map.clear();
        }
        
        return res;
    }
    
    private int dist(int[] a, int[] b) {
        int dX = a[0] - b[0];
        int dY = a[1] - b[1];
        return dX * dX + dY * dY;
    }
}
