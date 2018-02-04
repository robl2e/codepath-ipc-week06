public class SolutionBestTimeBuySellStocksII {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {
        if (A == null || A.isEmpty()) return 0;
        if (A.size() == 1) return 0;

        long totalProfit = 0;

        for (int i = 0; i < A.size()-1; i++) {
            int cur = A.get(i);
            int next = A.get(i+1);

            int profit = next - cur;
            if (profit > 0) {
                totalProfit += profit;
            }
        }
        return (int)totalProfit;
    }
}
