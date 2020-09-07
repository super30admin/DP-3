    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/delete-and-earn/
    Time Complexity for operators : o(m)
    Extra Space Complexity for operators : o(m) 
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : Followed the choose and don't choose approach as suggested in image. And found the repatative sub problem.
        # Optimized approach:  

              1. Get the max element to create the result array of (max+1). Then, create a result array by replacing input array with its position.             
              2. Form the two-d matrix. first row values will be same as given in input.
              3. we will start with second row and first column, at first position with will get the minimum of 2nd and 3rd elemnt of previous row.
              4. At second position with will get the minimum of 1st and 3rd elemnt of previous row.
              5. At third position with will get the minimum of 1st and 2nd elemnt of previous row.
              6. At the end, we will return min of last all last row values
    */  

    public class deleteAndEarn{
    public static void main(String args[]) {
                int nums[]= new int[] {3,4,2};
                System.out.println(deleteearn(nums));
            }
            
            
        public static int deleteearn(int nums[]) {
                      
        
                if(nums==null || nums.length==0)
                    return 0;
                
                int max = Integer.MIN_VALUE;
                for(int i=0;i<nums.length;i++){
                    if(nums[i]>max)
                        max = nums[i];
                }
                
                int result[] = new int[max+1];
                
                for(int i=0;i<nums.length;i++){
                    result[nums[i]] += nums[i];
                }
                
                int dp[][] = new int[result.length][2];
                dp[0][0] = result[0]; 
                dp[0][1] = 0;
                
                for(int i=1;i<result.length;i++){
                    dp[i][0] = result[i]+dp[i-1][1];
                    dp[i][1] = Math.max(dp[i-1][0],dp[i-1][1]);
                }
                return Math.max(dp[result.length-1][0],dp[result.length-1][1]);
        }
}