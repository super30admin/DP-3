package sol;


public class MinFallingPath {
	public int minFallingPathSum(int[][] matrix) {
	    
        int[][]dp = new int[matrix.length][matrix[0].length];
        
        for( int i=0;i<matrix[0].length;i++){
            dp[0][i]=matrix[0][i];
            
        }
        int ans=Integer.MAX_VALUE;
        for( int i=1;i<matrix.length;i++){
        
        for( int j=0;j<matrix[0].length;j++){
            
            int a=Integer.MAX_VALUE; 
             int c=Integer.MAX_VALUE;
             int b=Integer.MAX_VALUE;
            
            if(j-1>=0){a=dp[i-1][j-1];}
            
            if(j+1<matrix[0].length){ b=dp[i-1][j+1] ;}
            c=dp[i-1][j];
            
            dp[i][j]=matrix[i][j]+Math.min(a,Math.min(b,c));
                
             
                
            
        }    
            
        }
        for( int i=0;i<dp[0].length;i++){
            ans=Math.min(ans,dp[dp.length-1][i]);
        }
        
     return ans;
        
     
    }
	
	
}
