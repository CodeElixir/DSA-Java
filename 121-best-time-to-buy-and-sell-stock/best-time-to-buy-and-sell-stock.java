class Solution {
    public int maxProfit(int[] prices) {
        // int maxProf = 0;
        // int current = prices[0];
        // for (int i = 1; i < prices.length; i++) {
        //     if (prices[i] < current) {
        //         current = prices[i];
        //     } else {
        //         maxProf = Math.max(maxProf, prices[i] - current);
        //     }
        // }
        // return maxProf;
        int maxProf = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int currProf = prices[i] - min;
            maxProf = Math.max(maxProf, currProf);
            min = Math.min(min, prices[i]);
        }
        return maxProf;
    }
}