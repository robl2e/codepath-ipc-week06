public class SolutionStairs {
    HashMap<Integer, Integer> steps = new HashMap<>();

    public int climbStairs(int A) {
        if (A <= 1) {
            return 1;
        }

        int oneCount = 0;
        int twoCount = 0;
        if (steps.containsKey(A-1)) {
            oneCount = steps.get(A-1);
        } else {
            oneCount = climbStairs(A-1);
            steps.put(A-1, oneCount);
        }

        if (steps.containsKey(A-2)) {
            twoCount = steps.get(A-2);
        } else {
            twoCount = climbStairs(A-2);
            steps.put(A-2, twoCount);
        }

        return oneCount + twoCount;
    }
}
