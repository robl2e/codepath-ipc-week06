public class SolutionBestTimeBuySellStocks {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {
        if (A == null || A.isEmpty()) return 0;
        if (A.size() == 1) return 0;

        int minValue = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < A.size(); i++) {
            int price = A.get(i);
            if (price < minValue) {
                minValue = price;
            } else {
                int profit = price - minValue;
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }
}
