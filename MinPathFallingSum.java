// Time Complexity : 
//recursive method: exponential time
// DP method: O(n^2), where n is the number of elements in array a.
//space complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no
class MinPathFallingSum {
      int[]directions = {-1,0,1};
//     public int minFallingPathSum(int[][] a) {
//         if(a.length == 0){
//             return 0;
//         }
        
        
//         int minSum = Integer.MAX_VALUE;
//         for(int c = 0; c < a.length ;c++){
//             int currSum = recusriveHelper(a,0,c,0);
//             minSum = Math.min(minSum,currSum);
//         }
//         return minSum;     
//     }
    
//     private int recusriveHelper(int[][] a, int row,int col,int sum){
//         if(row == a.length){
//             return sum;
//         }
        
//        int currminSum = Integer.MAX_VALUE; 
//        for(int k =0;  k < 3 ;k++)
//        {
           
//            if(col + directions[k] >= 0 && col+ directions[k] < a[row].length){
//                 int currsum = recusriveHelper(a,row+1,col + directions[k], sum + a[row][col]);
//                 currminSum = Math.min(currsum,currminSum);
//            }
           
          
//        }
        
//         return currminSum;
//        // return minSum;
//     }
    
    public int minFallingPathSum(int[][] a){
        
        int n = a.length;
        if(n == 0){
            return 0;
        }
        int minSum = Integer.MAX_VALUE;
        for(int i = n-2; i >=0 ;i--){
            for(int j = 0; j < n;j++){
                int m1=Integer.MAX_VALUE;
                int m2 =Integer.MAX_VALUE;
                int m3 =Integer.MAX_VALUE;
                
                if(j + directions[0] >= 0 && j + directions[0] < n){                      
                             m1 = (a[i][j] + a[i+1][j+directions[0]]);
                } 
                if(j + directions[1] >= 0 && j + directions[1] < n){                      
                             m2 = (a[i][j] + a[i+1][j+directions[1]]);
                } 
                if(j + directions[2] >= 0 && j + directions[2] < n){                      
                             m3 = (a[i][j] + a[i+1][j+directions[2]]);
                }
                
                a[i][j] = Math.min(m1,Math.min(m2,m3));
            }   
    }
        for(int i = 0;i<n;i++){
            if(minSum > a[0][i]){
                minSum = a[0][i];
            }
        }   
    return minSum;
 }
}
