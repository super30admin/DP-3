import java.util.Arrays;

// DP (Top-Down)
// Time Complexity: O(n)
// Space Complexity: O(max + n)
class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max=0;
        for(int x:nums)  max = Math.max(max,x);
        int[] freq = new int[max+1];
        for(int x:nums)
            freq[x]++;
        Integer[] dp = new Integer[max+1];
        return f(freq,1,dp);
    }

    private int f(int[] freq , int i, Integer[] dp){
        if(i>=freq.length){
            return 0;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        int pick = freq[i]*i + f(freq,i+2,dp);
        int notPick = f(freq,i+1,dp);

        return dp[i] = Math.max(pick,notPick);
    }
}

// Recurssion
// Time Complexity: O(n log n
// Space Complexity: O(n * max(nums) + 1)
//class DeleteAndEarn {
//    public int deleteAndEarn(int[] nums) {
//        int n = nums.length;
//        Arrays.sort( nums);
//        int dp[][] = new int[n][nums[n-1]+1];
//        for(int row[]: dp) Arrays.fill( row , -1);
//        return  f( 0, -1 , nums, dp);
//    }
//    public int f( int i , int prev , int nums[], int dp[][]){
//        if( i==nums.length)  return 0;
//        if( prev!=-1){
//            if( dp[i][prev] !=-1) return dp[i][prev];
//        }
//        int points =0;
//        if( nums[i]!= prev-1 && nums[i]!=prev+1){
//            points = Math.max( f( i+1, prev, nums, dp), nums[i]+ f( i+1 , nums[i], nums, dp) );
//        }else
//            points =  f( i+1, prev, nums, dp );
//
//        if( prev!=-1)
//            dp[i][prev] = points;
//        return points;
//    }
//}