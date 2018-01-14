public class SolutionJumpGameArray {
    public static final int TRUE = 1;
    public static final int FALSE = 0;

    /*
        A = [2,3,1,1,4], return 1 ( true ).
        A = [3,2,1,0,4], return 0 ( false ).
    */
    public int canJump(ArrayList<Integer> A) {
        if (A == null || A.isEmpty()) return TRUE;
        if (A.size() == 1) return TRUE;

        int maxJump = A.get(0);
        for (int i = 0; i < A.size(); i++) {
            int jump = A.get(i);
            if (maxJump <= i && jump == 0) {
                return FALSE;
            }

            if (i + jump >= maxJump) {
                maxJump = i+jump;
            }

            if (maxJump >= A.size()-1) {
                return TRUE;
            }
        }
        return TRUE;
    }
}
