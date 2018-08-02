// https://leetcode.com/problems/plus-one/
class Solution { // 0ms
    public int[] plusOne(int[] digits) {
        final int len = digits.length;
        boolean addOne = false;
        
        digits[len - 1]++;
        
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] == 10) {
                digits[i] = 0;
                if(i != 0) {
                    digits[i - 1]++;
                } else {
                    addOne = true;
                }
            }
        }
        
        if (addOne) {
            int[] res = new int[len + 1];
            res[0] = 1;
            
            for (int i = 0; i < len; i++) {
                res[i + 1] = digits[i];
            }
            
            return res;
        }
        
        return digits;
    }
}

class Solution2 { // 0ms
    public int[] plusOne(int[] digits) {
        final int len = digits.length;
        
        digits[len - 1]++;
        
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] == 10) {
                digits[i] = 0;
                if(i != 0) {
                    digits[i - 1]++;
                }
            } else {
                return digits; // can return digits here directly, it is faster, and the boolean addOne is not need
            }
        }
        
        int[] res = new int[len + 1];
        res[0] = 1;

        for (int i = 0; i < len; i++) {
            res[i + 1] = digits[i];
        }

        return res;
    }
}
