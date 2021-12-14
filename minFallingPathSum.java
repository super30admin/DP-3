/*
2       1       3       10
6       5       4       5
7       8       9       1

Let's try exhaustive
    2
6       5

    1
6   5   4

    3
5   4   5

    10
4       5

Same as Dp-2 - painthouse just one condition 

t.c -> O(m*n)
s.c -> O(1)
*/
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0)return 0;

        for(int r = 1; r < matrix.length;r++){
            for(int c = 0; c < matrix[0].length;c++){
                if(c == 0){
                    matrix[r][c] += Math.min(matrix[r-1][c], matrix[r-1][c+1]); 
                }else if(c == matrix[0].length-1){
                    matrix[r][c] += Math.min(matrix[r-1][c], matrix[r-1][c-1]); 
                }else{
                    matrix[r][c] += Math.min(matrix[r-1][c], Math.min(matrix[r-1][c-1], matrix[r-1][c+1])); 
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        for(int c = 0; c < matrix[0].length; c++){
            ans = Math.min(matrix[matrix.length - 1][c], ans);
        }
        return ans;
    }
} 