// https://leetcode.com/problems/min-cost-climbing-stairs/
class Solution // 11ms
{
	public int minCostClimbingStairs(final int[] cost)
	{
		final int len = cost.length;

		for (int i = 2; i < len; i++)
		{
			cost[i] += Math.min(cost[i - 1], cost[i - 2]);
		}

		return Math.min(cost[len - 1], cost[len - 2]);
	}
}
