// https://leetcode.com/problems/maximum-length-of-repeated-subarray/
class Solution { // 58 ms
	public int findLength(final int[] A, final int[] B) {
		final int lenA = A.length, lenB = B.length;
		final int[][] dp = new int[lenA + 1][lenB + 1];
		int max = 0;

		for (int iA = lenA - 1; iA >= 0; iA--) {
			for (int iB = lenB - 1; iB >= 0; iB--) {
				if (A[iA] == B[iB]) {
					dp[iA][iB] = dp[iA + 1][iB + 1] + 1;
					if (dp[iA][iB] > max) {
						max = dp[iA][iB];
					}
				}
			}
		}

		return max;
	}
}

class Solution { // 17 ms
	public int findLength(final int[] A, final int[] B) {
		final int lenA = A.length, lenB = B.length;
		final int[] dp = new int[lenB + 1];
		int max = 0;

        // for each num in A, fill dp array
		for (int iA = 0; iA < lenA; iA++) {
			for (int iB = lenB - 1; iB >= 0; iB--) {
				if (A[iA] == B[iB]) {
					dp[iB + 1] = dp[iB] + 1;
                    
					if (max < dp[iB + 1]) {
						max = dp[iB + 1];
					}
				} else {
                    dp[iB + 1] = 0;
                }
			}
		}

		return max;
	}
}
