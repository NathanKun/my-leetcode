// https://leetcode.com/problems/rotate-image/
class Solution {
	public void rotate(final int[][] matrix) {
		final int n = matrix.length;

		if (n == 1 || n == 0) {
			return;
		}

		for (int depth = 0; depth < (n + 1) / 2; depth++) {
			if (depth == n - depth - 1) {
				continue; // skip the center
			}

			for (int i = depth; i < n - depth - 1; i++) {
				int tmp = matrix[i][n - depth - 1];
				matrix[i][n - depth - 1] = matrix[depth][i];

				final int tmp2 = matrix[n - depth - 1][n - 1 - i];
				matrix[n - depth - 1][n - 1 - i] = tmp;

				tmp = matrix[n - 1 - i][depth];
				matrix[n - 1 - i][depth] = tmp2;

				matrix[depth][i] = tmp;
			}
		}
	}
}
