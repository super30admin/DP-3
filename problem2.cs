public class Solution {
    public int MinFallingPathSum(int[][] matrix) {
        var m = matrix.Length;
        var n= matrix[0].Length;
        //int [,] dp=new int[m,n];
        //for(var i=0;i<n;i++)
          //dp[m-1,i] = matrix[m-1][i];
        for(var j=m-2;j>=0;j--)
        {
            for(var k=0;k<n;k++)
            {
                var below = matrix[j+1][k];
                var leftCorner = int.MaxValue;
                if(k-1>=0)
                {
                    leftCorner = matrix[j+1][k-1];
                }
                var rightCorner = int.MaxValue;
                if(k+1<n)
                {
                   rightCorner = matrix[j+1][k+1];
                }
                matrix[j][k] = matrix[j][k] + Math.Min(below,Math.Min(leftCorner,rightCorner));
            }
        }

        int result =int.MaxValue;
        for(var h=0;h<n;h++)
        {
            //Console.WriteLine(dp[0,h]);
              result = Math.Min(result,matrix[0][h]);
        }
        return result;
    }
}