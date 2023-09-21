
class Solution {
    // TC : O(n) SC: O(max+1) ... max = greatest integer in input array
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums)
            max = Math.max(max, num);
        int[] arr = new int[max + 1];
        for (int num : nums)
            arr[num] += num;
        int choose = 0;
        int notChoose = 0;
        for (int i = 1; i < arr.length; i++) {
            int temp = notChoose;
            notChoose = Math.max(choose, notChoose);
            choose = temp + arr[i];
        }
        return Math.max(choose, notChoose);
    }

    // TC: O(n^2) SC: O(1)
    public int minFallingPathSum(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int add = 0;
                if (j == 0)
                    add = Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]);
                else if (j == matrix[0].length - 1)
                    add = Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]);
                else
                    add = Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][j - 1], matrix[i - 1][j + 1]));

                matrix[i][j] += add;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            min = Math.min(min, matrix[matrix.length - 1][i]);
        }
        return min;
    }

}
