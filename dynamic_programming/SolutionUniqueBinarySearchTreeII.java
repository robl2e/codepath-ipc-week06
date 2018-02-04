public class SolutionUniqueBinarySearchTreeII {

    int[] store;

    public int numTrees(int A) {
        store = new int[A];
        return numTreesUtil(A);
    }

    public int numTreesUtil(int A) {
        if (A <= 1) return 1;

        int ret = 0;

        // 1 to A choices for root of tree
        for (int i = 0; i < A; i++) {

            // Check store for value
            int left = 0;
            if (store[i] != 0) {
                left = store[i];
            } else {
                // Left subtree combinations
                // if i = root
                // there are i-1 numbers for left
                // i.e. choosing from 1 to i-1
                left = numTreesUtil(i);
                store[i] = left;
            }

            // Check store for value
            int right = 0;
            if (store[A-i-1] != 0) {
                right = store[A-i-1];
            } else {
                // Right subtree combinations
                // if i == root
                // A-i numbers for right
                // i.e. choosing from i+1 to A
                right = numTreesUtil(A-i-1);
                store[A-i-1] = right;
            }

            // Combinations
            // i-1 trees formed from
            // left and right
            ret += left * right;
        }

        return ret;
    }

}
