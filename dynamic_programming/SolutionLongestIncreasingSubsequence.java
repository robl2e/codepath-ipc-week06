public class SolutionLongestIncreasingSubsequence {
    private int longest = 1;
    private HashMap<Integer, Integer> seqMap =
        new HashMap<Integer, Integer>();

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lis(final List<Integer> A) {
        lisUtil(A, A.size());
        return longest;
    }

    public int lisUtil(List<Integer> A, int len) {
        // Base Case
        if (len == 1) {
            return 1;
        }

        int seqLen = 1;
        int ret = 1;

        for (int i = 1; i < len; i++) {
            if (seqMap.containsKey(i)) {
                ret = seqMap.get(i);
            } else {
                ret = lisUtil(A, i);
            }
            int first = A.get(i-1);
            int last = A.get(len-1);
            if ((first < last) && (ret + 1 > seqLen)) {
                seqLen = ret + 1;
            }
        }
        seqMap.put(len, seqLen);
        longest = Math.max(longest, seqLen);
        return seqLen;
    }
}
