// https://leetcode.com/problems/maximize-distance-to-closest-person/
class Solution {
    public int maxDistToClosest(int[] seats) {
        int count = 0;
        int max = 0;
        int i = 0;
        while (seats[i] == 0) {
            max += 2; // divide by 2 later
            i++;
        }
        
        for (; i < seats.length; i++) {
            if (seats[i] == 0) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                }
                count = 0;
            }
        }
        
        if (max % 2 == 1) {
            max++;
        }
        max = max / 2;
        
        return max > count ? max : count;
    }
}
