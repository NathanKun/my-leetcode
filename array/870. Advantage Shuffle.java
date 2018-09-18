// https://leetcode.com/problems/advantage-shuffle/
class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        Map<Integer, Integer> map = new HashMap();
        List<int[]> list = new ArrayList();
        int[] res = new int[A.length];
        int aMax = -1;
        int aMin = Integer.MAX_VALUE;
        
        for (int n : A) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            
            if (n > aMax) {
                aMax = n;
            }
            
            if (n < aMin) {
                aMin = n;
            }
        }
        
        SortedSet<Integer> keys = new TreeSet<>(map.keySet());
        for (Integer key : keys) { 
           list.add(new int[]{key, map.get(key)});
        }
        
        for (int i = 0; i < B.length; i++) {
            int n = B[i];
            int iMap = 0;
            boolean found = false;
            
            for (int iList = 0; iList < list.size(); iList++) {
                int[] l = list.get(iList);
                int key = l[0];
                int val = l[1];
                
                if (key > n) {
                    n = key;
                    found = true;
                    
                    int newVal = val - 1;
                    if (newVal > 0) {
                        l[1] = newVal;
                    } else {
                        list.remove(iList);
                    }
                    
                    break;
                }
            }
            
            if (found) {
                res[i] = n;
            } else {
                for (int iList = 0; iList < list.size(); iList++) {
                    int[] l = list.get(iList);
                    int key = l[0];
                    int val = l[1];
                    
                    int newVal = val - 1;
                    if (newVal > 0) {
                        l[1] = newVal;
                    } else {
                        list.remove(iList);
                    }

                    res[i] = key;
                    break;
                }
            }
        }
        
        return res;
    }
}
