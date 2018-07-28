// 
class Solution {
    public int maxProfit(int[] prices) {
        final int len = prices.length;
        
        if (len == 0) {
            return 0;
        }
        
        int benefit = 0;
        int low = prices[0];
        int high = 0;
        int day = 0;
        
        while (day + 1 < len) {
            // wait low peak to buy
            while (day + 1 < len && prices[day] > prices[day + 1]) {
                day++;
                low = prices[day];
            }
            if (day < len - 1){
            	high = 0;
            }
            
            // wait high peak to sell
            while (day + 1 < len && prices[day] < prices[day + 1]) {
                day++;
                high = prices[day];
            }
            
            if (high != 0) {
                benefit += high - low;
                high = 0;
            }
            day++;
            if (day < len - 1){
                low = prices[day];
            }
        }
        
        return benefit;
    }
}
