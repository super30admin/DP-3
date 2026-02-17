// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Time Complexity : O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes it did
// Challenge was to determine how to use 1D array

class Sample {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[] prev = new int[n];

        for (int j = 0; j < n; j++) {
            prev[j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[n];

            for (int j = 0; j < n; j++) {
                int minAbove = prev[j];

                if (j > 0) {
                    minAbove = Math.min(minAbove, prev[j - 1]);
                }
                if (j < n - 1) {
                    minAbove = Math.min(minAbove, prev[j + 1]);
                }

                curr[j] = matrix[i][j] + minAbove;
            }

            prev = curr;
        }

        int ans = prev[0];
        for (int j = 1; j < n; j++) {
            ans = Math.min(ans, prev[j]);
        }

        return ans;
    }

    // Time Complexity : O(Max_value + N)
    // Space Complexity : O(Max_value)
    // Did this code successfully run on Leetcode : Yes it did
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) return 0;

        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // create array for points
        int[] points = new int[max + 1];
        for (int num : nums) {
            points[num] += num;
        }

        int take = 0;
        int skip = 0;

        max = 0;

        for (int j = 0; j < points.length; j++) {
            if (j - 2 == 0) {
                points[j] = points[j - 2] + points[j];
            } else if (j - 2 > 0) {
                points[j] = points[j - 2] > points[j - 3] ? points[j - 2] + points[j] : points[j - 3] + points[j];
            }
            max = Math.max(points[j], max);
        }
        return max;

    }

}