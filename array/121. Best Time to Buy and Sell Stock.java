// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class Solution {
    public int maxProfit(int[] prices) {
        final int len = prices.length;
        int benefit = 0;
        int min = prices[0];
        
        for (int p : prices) {
            min = Math.min(p, min);
            benefit = Math.max(benefit, p - min);
        }
        
        return benefit;
    }
}
