// https://leetcode.com/problems/divide-two-integers/
class Solution { // 1ms 32.7 MB
    public int divide(int dividend, int divisor) {
        return divideFun(dividend, divisor);
    }
    
    private int divideFun(int dividend, int divisor) {
        if (divisor == Integer.MIN_VALUE) {
            if (dividend > divisor) {
                return 0;
            } else {
                return 1;
            }
        }
        
        boolean neg = false;
        boolean minVal = false;
        
        if (divisor < 0) {
            neg = true;
            divisor *= -1;
        }
        
        if (dividend < 0) {
            if (dividend == Integer.MIN_VALUE) {
                dividend++;
                minVal = true;
            }
            neg = !neg;
            dividend *= -1;
        }

        if (dividend < divisor) return 0;
        
        int plus = neg ? -1 : 1;        
        int res = 1;
        int sum = divisor;
        
        while (sum < 1073741824 && dividend >= (sum + sum)) {
            sum += sum;
            res += res;
        }
        
        if (minVal) {
            dividend++;
        }
        
        int recusiveRes = divideFun(dividend - sum, divisor);
        
        if (plus > 0 && recusiveRes >= 0 && res >= 0 && res + recusiveRes < 0) {
            return Integer.MAX_VALUE;
        } else {
            return plus * (res + recusiveRes);
        }
    }
}
