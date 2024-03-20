class Solution {
    public int my_func(int[][] grid, int gridSize, int gridColSize,int i,int j,int[][]array)
   {
        if(i==gridSize-1&&j>=0&&j<gridColSize)
       {
           return grid[i][j];
       } 
       if(i>gridSize-1||j>gridColSize-1||j<0)
       {
            return Integer.MAX_VALUE;
       }
      if(array[i][j]!=Integer.MAX_VALUE)
            return array[i][j];
     
        array[i][j]=grid[i][j]  + Math.min(Math.min(my_func(grid,gridSize,gridColSize,i+1,j,array)
 ,my_func(grid,gridSize,gridColSize,i+1,j+1,array)),my_func(grid,gridSize,gridColSize,i+1,j-1,array));
       return array[i][j];
       
   }
   
  
    public int minFallingPathSum(int[][] matrix) {
        
    int gridSize=matrix.length;
    int gridColSize=matrix[0].length;
    int  [][]array=new int[gridSize][gridColSize];
    int i=0,j=0;
    int ans=Integer.MAX_VALUE;
    int result;
    for( i=0;i<gridSize;i++)
    {
        for(j=0;j<gridColSize;j++)
        {
            array[i][j]=Integer.MAX_VALUE;
        }
    }
   for(i=0;i<gridColSize;i++)
   {
    result=my_func(matrix,gridSize,gridColSize,0,i,array);
    if(result<ans)
    ans=result;
   }
    return ans;
        
    }
}