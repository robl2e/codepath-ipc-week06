
public class SolutionMinSumPathMatrix {
    public int minPathSum(ArrayList<ArrayList<Integer>> A) {
        if (A == null || A.isEmpty()) return 0;

        if (A.size() == 1) {
            ArrayList<Integer> cols = A.get(0);
            int sum = 0;
            for (Integer num : cols) {
                sum += num;
            }
            return sum;
        }

        int rowLen = A.size();
        int colLen = A.get(0).size();
        int[][] matrix = new int[rowLen][colLen];

        // Convert to 2D array
        for (int r = 0; r < rowLen; r++) {
            ArrayList<Integer> cols = A.get(r);
            for (int c = 0; c < colLen; c++) {
                matrix[r][c] = cols.get(c);
            }
        }

        int[][] sum = minPathSumUtil(matrix);
        //System.out.println(Arrays.deepToString(sum));
        return sum[rowLen-1][colLen-1] + matrix[0][0];
    }

    public int[][] minPathSumUtil(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int[][] sum = new int[rowLen][colLen];

        // Initialize topmost row
        for (int c = 1; c < colLen; c++) {
            // sum at [0,c] = sumOfPrevToLeft + sumOfCurrent
            sum[0][c] = sum[0][c-1] + matrix[0][c];
        }

        // Initialize leftmost col
        for (int r = 1; r < rowLen; r++) {
            // sum at [r,0] = sumOfPrevTop + sumOfCurrent
            sum[r][0] = sum[r-1][0] + matrix[r][0];
        }


        // Calculate path
        for (int r = 1; r < rowLen; r++) {
            for (int c = 1; c < colLen; c++) {
                int top = sum[r-1][c];
                int left = sum[r][c-1];
                // sum - sumOfPrevPath (either top or left) + sumOfCurrent
                sum[r][c] = Math.min(top, left) + matrix[r][c];
                //System.out.println("r = " + r + " c = " + c + " sum = " + sum[r][c]);
            }
        }
        return sum;
    }
}
