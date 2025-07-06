class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        for(int j=0;j<n;j++)
        {
            min=Math.min(min,recurse(matrix,0,j));
        }
        return min;
    }

    private int recurse(int[][] matrix,int row,int column)
    {
        int n = matrix.length;
        if(row==n){
         return 0;
        }

        if(column < 0 || column >= n){
            return Integer.MAX_VALUE;
        }

        int down = recurse(matrix,row+1,column);
        int downright = recurse(matrix,row+1,column+1);
        int downleft = recurse(matrix,row+1,column-1);
       
        return matrix[row][column] + Math.min(down,Math.min(downleft,downright));
      

       
    }
}
