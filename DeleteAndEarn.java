 //Time Complexity  : o(m)
 //Space Complexity  : o(m) 
public class DeleteAndEarn {
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
         int C  = 0;
         int DC = 0;

         for(int num : result){
             int temp = DC;
             DC = Math.max(C,DC);
             C = num + temp;
         }
         return Math.max(C,DC);

         // int dp[][] = new int[result.length][2];
         // dp[0][0] = result[0]; 
         // dp[0][1] = 0;

         // for(int i=1;i<result.length;i++){
         //     dp[i][0] = result[i]+dp[i-1][1];
         //     dp[i][1] = Math.max(dp[i-1][0],dp[i-1][1]);
         // }
         // return Math.max(dp[result.length-1][0],dp[result.length-1][1]);
 }
} 