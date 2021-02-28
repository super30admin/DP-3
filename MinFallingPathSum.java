//Time Complexity: O(n^2)
//Space Complexity: O(n)
//Executed on leet code.
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int len = matrix.length;
        if(len==0)return 0;
       
        //int[][] dp=new int[len][len];
        int []dp = new int[len];
        
        for(int i=0;i<len;i++)
            dp[i] = matrix[0][i];					//I compare sum of each element with previous not same index and choose the minimum value
        
        for(int i=1;i<len;i++)								//Likewise I do same for each row and at the end I return maximum of the value got at last row.
        {
            int []temp=new int[len];
            for(int j=0;j<len;j++)
            {
                int min = Integer.MAX_VALUE;
                if(j!=0)
                    if(matrix[i][j]+dp[j-1]<min)
                        min = matrix[i][j]+dp[j-1];
                if(matrix[i][j]+dp[j]<min)
                        min = matrix[i][j]+dp[j];
                if(j<len-1)
                    if(matrix[i][j]+dp[j+1]<min)
                        min = matrix[i][j]+dp[j+1];
                 temp[j] = min;   
            }
            dp = temp;
        }  
        int min =Integer.MAX_VALUE;
        for(int i=0;i<len;i++)
            if(dp[i]<min)
                min = dp[i];
        return min;
    }
}