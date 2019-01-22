// https://leetcode.com/problems/happy-number/
class Solution { // 1 ms: https://leetcode.com/problems/happy-number/discuss/56917/My-solution-in-C(-O(1)-space-and-no-magic-math-property-involved-)/210043 
    public boolean isHappy(int n) {
        if(n == 1 || n == 7) return true;
        else if(n < 10) return false;
        int m = 0;
        while(n != 0){
            int tail = n % 10;
            m += tail * tail;
            n = n/10;
        }
        return isHappy(m);
    }
}
