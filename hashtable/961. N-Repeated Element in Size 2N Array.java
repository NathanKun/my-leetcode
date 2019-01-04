// https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
class Solution {
    public int repeatedNTimes(int[] A) {
        int[] set = new int[10000];
        
        for (int n : A) {
            if (set[n] == 1) {
                return n;
            }
            set[n]++;
        }
        
        return -1;
    }
}
