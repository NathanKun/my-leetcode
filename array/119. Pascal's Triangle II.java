// https://leetcode.com/problems/pascals-triangle-ii/
// math formula: https://www.mathsisfun.com/pascals-triangle.html

import java.math.BigInteger;
class Solution1 { //  4 ms
    public List < Integer > getRow(final int rowIndex) {
        final List < Integer > res = new ArrayList();

        for (int i = 0; i < rowIndex + 1; i++) {
            res.add(combination(rowIndex, i));
        }

        return res;
    }

    private BigInteger factorial(final int n, final int end) { // if use long, will overflow at n = 30
        if (n == end) {
            return BigInteger.ONE;
        }

        BigInteger res = BigInteger.valueOf(n);
        for (int i = n - 1; i > end; i--) {
            res = res.multiply(BigInteger.valueOf(i));
        }

        return res.equals(BigInteger.ZERO) ? BigInteger.ONE : res;
    }

    // n choose k
    private int combination(final int n, final int k) {
        if (n <= k) {
            return 1;
        }

        if (k > n - k) {
            return factorial(n, k).divide(factorial(n - k, 0)).intValue();
        } else {
            return factorial(n, n - k).divide(factorial(k, 0)).intValue();
        }

    }
}

class Solution2 { // 2ms
	public List<Integer> getRow(final int rowIndex) {
		final List<Integer> res = new ArrayList();

		for (int i = 0; i < rowIndex + 1; i++) {
			res.add(0, 1);
            
            for (int j = 1; j < i; j++) {
                res.set(j, res.get(j) + res.get(j + 1));
            }
		}

		return res;
	}
}
