public class MinFallingSumRec {
    public int minFallingPathSum(int[][] A) {

        return minFallingPathSumRec(A, 1, 0);

    }

    public int minFallingPathSumRec(int[][] A, int row, int col) {
        if (A.length == 0)
            return 0;

        if (col == 0) {
            A[row][col] += Math.min(A[row - 1][col], A[row - 1][col + 1]);
        }
        if (col == A.length) {
            A[row][col] += Math.min(A[row - 1][col - 1], A[row - 1][col]);
        } else {

            A[row][col] += Math.min(A[row - 1][col - 1], Math.min(A[row - 1][col], A[row - 1][col + 1]));
        }
        int min = A[A.length - 1][0];

        while (col < A.length) {
            min = Math.min(min, minFallingPathSumRec(A, A.length - 1, 1));
        }
        return min;
    }

    public static void main(String args[]) {
        MinFallingSum obj = new MinFallingSum();
        int[][] arr = { { 51, 24 }, { -50, 82 } };
        System.out.println("Min Falling Path is = " + obj.minFallingPathSum(arr));

    }
}