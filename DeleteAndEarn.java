// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No 


// Your code here along with comments explaining your approach

//Tabulation approach:-

  class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
       int max=Integer.MIN_VALUE;
        for(int i:nums){
           max=Math.max(i,max);
        } 
        // get maximum element and then initialize the frequncy array with size max+1
        int[] freq=new int[max+1];
        // now it works like House robber problem
        /*where index i represents frequency of i and you can't pick      consequetive elemets*/
        for(int i:nums){
            freq[i]++;
        }
        //modifying frequency to total cost
       for(int i=0;i<max+1;i++){
           freq[i]*=i;
       }
        
        int[] dp=new int[max+1];
        dp[0]=freq[0];
        if(max+1>1){
            dp[1]=Math.max(dp[0],freq[1]);
        }
        for(int i=2;i<max+1;i++){
           int left=dp[i-2]+freq[i];
            int right=dp[i-1];
            dp[i]=Math.max(left,right);
        }
        //returning maximum cost we can get through the procesue in the program
        return dp[max];
    }
}