public class SolutionDigitNumWithDigitSum {

    static int store[][] = new int[1001][5001];

    public int solve(int N, int S) {
        if (N == 1 && S < 10) return 1;

        // Initialize all entries of memoization table
        for(int i = 0; i <= 1000; ++i){
            Arrays.fill(store[i], -1);
        }

        int ans = 0;
        // Recurse all digits 1-9
        for (int i = 1; i <= 9; i++) {
             if (S-i >= 0) {
                 int part = solveUtil(N-1, S-i);
                 // modulo done on intermediate step
                 // whenever adding
                 ans = ((ans + part) % 1000000007);
             }
        }
        return ans;
    }

    // Method does not handle leading digits 0
    private int solveUtil(int N, int S) {
        if (N == 0) {
            return S == 0 ? 1 : 0;
        }
        if (S == 0) return 1;

        if (store[N][S] != -1) {
            return store[N][S];
        }

        int ret = 0;
        for (int i = 0; i <= 9; i++) {
            if (S-i >= 0) {
                int part = solveUtil(N-1, S-i);
                 // modulo done on intermediate step
                 // whenever adding
                ret = ((ret + part) % 1000000007);
            }
        }
        store[N][S] = ret;
        return ret;
    }

}
