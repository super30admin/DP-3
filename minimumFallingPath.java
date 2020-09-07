    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/minimum-falling-path-sum/
    Time Complexity for operators : o(m*n)
    Extra Space Complexity for operators : o(1) 
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : Followed the choose and don't choose approach as suggested in image. And found the repatative sub problem.
        # Optimized approach: . 
                              
            # 1. Traverse from the matrix and compare the previous values in following mannner: Start from 2nd row.
                    A) if it is at 1st column then get the min from above and right of the above element.
                    B) if element is in last column then get min from above and left of the above element
                    C) if element is in middle then get min of abive, right of the above, and left of the above and add to current element.
              2. At the  end, return minimum of the last entire  row.
    */  

    public class minimumFallingPath{
    public static void main(String args[]) {
                int A[][]= new int[][] {{1,2,3},{4,5,6},{7,8,9}};
                System.out.println(minCost(A));
            }
            
            
        public static int minCost(int A[][]) {
                      
            if(A==null || A.length == 0 || A[0].length == 0)
                return 0;
            
            for(int i=1;i<A.length;i++){
                for(int j=0;j<A[0].length;j++){
                    
                    if(j == 0){
                        A[i][j] += Math.min(A[i-1][j],A[i-1][j+1]);
                    }else if(j == A[0].length-1){
                        A[i][j] += Math.min(A[i-1][j],A[i-1][j-1]);
                    }else{
                        A[i][j] += Math.min(A[i-1][j-1],Math.min(A[i-1][j],A[i-1][j+1]));
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for(int num : A[A.length-1]){
                if(num < min)
                    min = num;
            }
            return min;
        }
}