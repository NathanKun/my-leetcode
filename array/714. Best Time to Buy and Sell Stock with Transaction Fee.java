// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
class Solution1 { // Time Limit Exceeded
    public int maxProfit(int[] prices, int fee) {
        final int len = prices.length;
        if (len == 0 || len == 1) {
            return 0;
        }
        
        return nextDay(prices, fee, 0, 0, 0, false);
    }
    
    private int nextDay(int[] prices, int fee, int day, int profit, int holdingPrice, boolean isHolding) {
        
        if (day >= prices.length) {
            return profit;
        }
        
        final int dayP1 = day + 1;
        final int price = prices[day];
        int p1, p2;
        
        if (isHolding) { // holding
            // not sell
            p1 = nextDay(prices, fee, dayP1, profit, holdingPrice, true);
            
            // sell
            if (price - fee - holdingPrice > 0) {
                p2 = nextDay(prices, fee, dayP1, profit + (price - fee - holdingPrice), 0, false);
            } else {
                return p1;
            }
            
        } else { // not holding
            // buy
            p1 = nextDay(prices, fee, dayP1, profit, price, true);
            
            // not buy
            p2 = nextDay(prices, fee, dayP1, profit, 0, false);
        }
            
        return Math.max(p1, p2);
    }
}

class Solution2 { // 9ms - 14ms
    public int maxProfit(int[] prices, int fee) {
        // We have 2 array
        // holdArray has max profit of all days that we are in state holding stock
        // soldArray has max profit of all days that we are in state not holding stock
        // 
        // for holdArray at day i, there are 2 possibilities
        //     hold at day i-1, so do nothing
        //     sold at day i-1, buy at day i, so pay prices[i]
        //
        // for soldArray at day i, there are 2 possibilities
        //     sold at day-1, so do nothing
        //     hold at day-1, sell at day i, so earn profits(price[i] - fee)
        //
        // for day 0, holdArray[0] = -prices[0] (buy at day 0), soldArray[0] = 0 (nothing to sell at day 0)
        
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        
        int[] holdArray = new int[prices.length];
        int[] soldArray = new int[prices.length];
        
        holdArray[0] = -prices[0];
        //soldArray[0] = 0;
        
        for (int day = 1; day < prices.length; day++) {
            holdArray[day] = Math.max(holdArray[day - 1], soldArray[day - 1] - prices[day]);
            soldArray[day] = Math.max(soldArray[day - 1], holdArray[day - 1] + prices[day] - fee);
        }
        
        return Math.max(holdArray[prices.length - 1], soldArray[prices.length - 1]);
    }
}

class Solution3 { // 6ms
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        
        int buyP = prices[0]; // equivalent buy price
        int profit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            final int price = prices[i];
            if (buyP > price) { // if day price is low
                buyP = price;   // may buy at this lower price
            } else { // if day price is high
                if (price - buyP - fee > 0) {
                    profit += price - buyP - fee; // buy with buyP and sell at this high price
                    buyP = price - fee; // equivalent that we may buy at price price[i]-fee next time
                }
            }
        }
        
        return profit;
    }
}
