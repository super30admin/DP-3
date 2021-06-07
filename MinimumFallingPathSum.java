// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        //Similar to house coloring problem
        if(matrix==null||matrix.length==0)
            return 0;
        //Stating at the second last row and finding minimum paths that can be added while going up
        for(int i=matrix.length-2;i>=0;i--)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(j==0)
                {
                    //at the first column you cannot have j-1 column
                    
                    matrix[i][j]+=Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                    
                }
                else if(j==matrix[i].length-1)
                {
                    //at the last column you cannot have j+1 column
                   matrix[i][j]+=Math.min(matrix[i+1][j],matrix[i+1][j-1]);
                }
                else{
                    matrix[i][j]+=Math.min(Math.min(matrix[i+1][j],matrix[i+1][j-1]),matrix[i+1][j+1]);
                }
            }
        }
        int min=Integer.MAX_VALUE;
        //finding the minimum among the Path Sums at the first row
        for(int j=0;j<matrix[0].length;j++)
        {
            min=Math.min(min,matrix[0][j]);
        }
        
        return min;
    }
    public static void main(String[] args)
    {
        MinimumFallingPathSum obj=new MinimumFallingPathSum();
        int[][] matrix={{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(obj.minFallingPathSum(matrix));
    }
}