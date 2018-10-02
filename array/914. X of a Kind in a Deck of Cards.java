// https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        // map<card, count>
        Map<Integer, Integer> map = new HashMap();
        
        for (int n : deck) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        int max = Integer.MIN_VALUE;
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = Math.max(entry.getValue(), max);
        }
        
        long cd = map.get(deck[0]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            cd = commonDivisor(cd, val);
        }
        
        return cd >= 2 && cd <= max;
    }
    
    public long commonDivisor(long n, long m) {
        while (n % m != 0) {
            long temp = n % m;
            n = m;
            m = temp;
        }
        return m;
    }

}
