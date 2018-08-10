// https://leetcode.com/problems/teemo-attacking/
class Solution { // 40ms
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null) {
            return 0;
        }
        
        final int len = timeSeries.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return duration;
        }
        
        int damage = 0;
        int time = 0;
        int remain = 0;
        int index = 0;
        int next = timeSeries[index];
        
        while (time <= timeSeries[len - 1]) {
            if (time == next) {
                remain = duration;
                do {
                    index++;
                    next = index < len ? timeSeries[index] : 0;
                } while (next == time);
            }
            if (remain > 0) {
                damage++;
                remain--;
            }
            time++;
        }
        damage += remain;
        
        return damage;
    }
}

class Solution2 { // 5ms
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        final int len = timeSeries.length;
        if (len == 0) {
            return 0 ;
        }
        if (len == 1) {
            return duration;
        }
        
        int res = 0;
        int last = timeSeries[0];
        
        for (int i = 1; i < timeSeries.length; i++) {
            int val = timeSeries[i];
            if (val - last >= duration) {
                res += duration;
            } else {
                res += val - last;
            }
            last = val;
        }
        
        res += duration;
        
        return res;
    }
}
