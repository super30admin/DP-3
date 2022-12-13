package s30.dp.dp3;


// Algo similar to house robber instead we need to use count sort like array to start.
//TC: O(range); range -> diff between largest and smallest
//SC: O(range);
public class DeleteAndEarn {

    private int small, large;

    public int deleteAndEarn(int[] nums) {

        getSmallAndLarge(nums);

        int dp[] = new int[large - small + 1];

        for(int num : nums){
            dp[num - small] += num;
        }

        for(int i = 1; i < dp.length; i++){

            int select = i==1 ? dp[i] :  dp[i] + dp[i-2];
            int notSelect = dp[i-1];
            dp[i] = Math.max(select, notSelect);
        }


        return dp[large - small];

    }

    private void getSmallAndLarge(int [] nums){

        small = Integer.MAX_VALUE;
        large = Integer.MIN_VALUE;

        for(int num : nums){
            small = Math.min(num, small);
            large = Math.max(num, large);
        }
    }
    public static void main(String[] args) {

    }
}
