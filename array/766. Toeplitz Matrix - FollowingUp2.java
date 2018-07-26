package test;

@SuppressWarnings("javadoc")
public class Main
{
	public static void main(final String[] args)
	{
		//[[36,59,71,15,26,82,87],[56,36,59,71,15,26,82],[15,0,36,59,71,15,26]]

		final int[][] matrix1 =
		{
				{ 36, 59, 71, 15, 26, 82, 87 },
				{ 56, 36, 59, 71, 15, 26, 82 },
				{ 15, 0, 36, 59, 71, 15, 26 } };

		final int[][] matrix2 =
		{
				{ 1, 2, 3 },
				{ 4, 1, 2 },
				{ 5, 4, 1 },
				{ 6, 5, 4 },
				{ 7, 6, 5 },
				{ 8, 7, 6 },
				{ 9, 2, 7 } };

		System.out.println(new Solution().isToeplitzMatrix(matrix1));
		System.out.println(new Solution().isToeplitzMatrix(matrix2));
	}

}
/**
 * https://leetcode.com/problems/toeplitz-matrix/description/
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 *
 * Follow up:
 * 1. What if the matrix is stored on disk, and the memory is limited such that you can only load 
 * at most one row of the matrix into the memory at once?
 * 2. What if the matrix is so large that you can only load up a partial row into the memory at once?
 */
class Solution
{
	private int[][] mx;
	private int rowCount;
	private int colCount;

	public boolean isToeplitzMatrix(final int[][] matrix)
	{
		mx = matrix;
		mockGetSize();

		// check every digonal
		for (int i = 0; i < rowCount + colCount - 1; i++)
		{
			System.out.println("index = " + i);
			if (!checkDiagonal(i))
			{
				return false;
			}
		}

		return true;
	}

	private int mockLoadValueFromDisk(final int r, final int c)
	{
		return mx[r][c];
	}

	private void mockGetSize()
	{
		rowCount = mx.length;
		colCount = mx[0].length;
	}

	/**
	 * Check one diagnal
	 */
	private boolean checkDiagonal(final int index)
	{
		if (rowCount > colCount)
		{
			int r = Math.min(rowCount - 1, index);
			int c = colCount - 1;
			if (index - rowCount + 1 > 0)
			{
				c -= index - rowCount + 1;
			}
			int a = mockLoadValueFromDisk(r, c);

			for (int i = 0; i < Math.min(Math.min(index + 1, colCount), rowCount + colCount - index - 1); i++)
			{
				final int b = mockLoadValueFromDisk(r, c);
				System.out.print(b + " ");

				if (a != b)
				{
					return false;
				}

				a = b;
				r--;
				c--;
			}
		}
		else
		{ // colCount > rowCount
			int r = 0;
			if (index - colCount + 1 > 0)
			{
				r += index - colCount + 1;
			}
			int c = Math.max(0, colCount - 1 - index);
			int a = mockLoadValueFromDisk(r, c);

			for (int i = 0; i < Math.min(Math.min(index + 1, rowCount), rowCount + colCount - index - 1); i++)
			{
				final int b = mockLoadValueFromDisk(r, c);
				System.out.print(b + " ");

				if (a != b)
				{
					return false;
				}

				a = b;
				r++;
				c++;
			}
		}
		System.out.println("");

		return true;
	}
}
