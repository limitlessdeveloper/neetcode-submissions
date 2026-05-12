class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        for(int currVal:prices){
            min = Math.min(currVal, min);
            maxProfit = Math.max(maxProfit, currVal-min);
        }
        return maxProfit;
    }
}