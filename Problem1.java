public class Problem1 {
    public int deleteAndEarn(int[] nums) {
        int max=0;
        for(int num: nums){
            max= Math.max(max,num);
        }   
        int[] pArray= new int[max+1];
        for(int num:nums){
            pArray[num]+=num;
        }

        int[] dp= new int[max+1];
        dp[0]= pArray[0];
        dp[1]= Math.max(dp[0],pArray[1]);
        for(int i=2;i<pArray.length;i++){
            dp[i]= Math.max(dp[i-1],pArray[i]+dp[i-2]);
        }
        return dp[max];
    }
}