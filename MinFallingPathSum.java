//time - O(mn) - O(n^2) - square array
//space - O(n^2) for the result array, can modify the input itself if allowed resulting in constant space
class Solution {
    public int minFallingPathSum(int[][] A) {
        if(A == null || A.length == 0 || A[0].length == 0)
        {
            return 0;
        }
        
        int[][] result = new int[A.length][A[0].length];
        
        for(int i = 0; i < A[0].length; i++)
        {
            //if the input has only row, the falling paths have only element, so copy directly
            result[0][i] = A[0][i];
        }
        
        for(int i = 1; i < A.length; i++)
        {
            for(int j = 0; j < A[0].length; j++)
            {
                if(j == 0)//first column
                {
                    int column1 = A[i][j] + result[i - 1][j];
                    int column2 = A[i][j] + result[i - 1][j + 1];
                    result[i][j] = Math.min(column1, column2);
                }
                else if(j == A[0].length - 1)//last column
                {
                    int column1 = A[i][j] + result[i - 1][j];
                    int column2 = A[i][j] + result[i - 1][j - 1];
                    result[i][j] = Math.min(column1, column2);
                }
                else//other columns
                {
                    int column1 = A[i][j] + result[i - 1][j];
                    int column2 = A[i][j] + result[i - 1][j + 1];
                    int column3 = A[i][j] + result[i - 1][j - 1];
                    result[i][j] = Math.min(column1, Math.min(column2,column3));
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < A[A.length - 1].length; i++)
        {
            answer = Math.min(answer, result[A.length - 1][i]);
        }
        return answer;
    }
}
