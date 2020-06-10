// Time Complexity : O(n * max(num))
// Space Complexity : O(max num)
// Did this code successfully run on Leetcode :  yes


// Your code here along with comments explaining your approach
import java.util.*;
class Main{
  public static void main(String []args){
    int []nums={2,2,3,3,3,4};
    System.out.println("The maximum points can be earrned will be : "+findMax(nums));
  }
  public static int findMax(int []nums){
    if(nums==null || nums.length==0){
      return 0;
    }
    int max=0;
    for(int n:nums){
      max=Math.max(max, n);
    }
    int []ar=new int[max+1];
    for(int n:nums){
      ar[n]=ar[n]+n;
    }
    int [][]dp=new int[ar.length][2];
    dp[0][1]=ar[0];

    for(int i=1;i<ar.length;i++){
      dp[i][0]=Math.max(dp[i-1][0], dp[i-1][1]);
      dp[i][1]=dp[i-1][0]+ar[i];
    }
    return Math.max(dp[ar.length-1][0], dp[ar.length-1][1]);
  }
}