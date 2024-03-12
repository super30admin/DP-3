class Solution {
    /**
        TC -> O(N square), where N is the length of the matrix col / row
        SC -> O(1) manipulated the input array itself, if not allowed, use a 2D dp matrix, and then the SC will become O(N square)

        Eg: [[1,2,3], [4,5,6], [7,8,9]]

        1               2               3

        4+min(1,2)      5+min(1,2,3)    6+min(2,3)

        7+min(5,6)      8+min(5,6,8)    9+min(6,8)

        Answer -> min(12,13,15)
     */
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int minRes = Integer.MAX_VALUE;
        if(matrix == null || n == 0) return Integer.MIN_VALUE;
        if(n == 1) return matrix[0][0];

        for(int i=1; i< n; i++){
            for(int j=0; j<n; j++){
                if(j == 0)
                    matrix[i][j] += Math.min(matrix[i-1][0], matrix[i-1][1]);
                else if(j == n - 1)
                    matrix[i][j] += Math.min(matrix[i-1][n-1], matrix[i-1][n-2]);
                else
                    matrix[i][j] += Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i-1][j+1]));
                if(i == n-1)
                    minRes = Math.min(minRes, matrix[i][j]);
            }
        }
        return minRes;
    }
}
