// Time complexity : Max (O(n), O(m)) n is size of input array and m is max value in input array
// Space Complexity: O(m)  m is max value in input array
// We can change this problem to look like the 'House Robber' game. Choosing a number means
// we cannot choose its neighbors. First, we add up the total points for each number.
// Then, we look at each number one by one to find the highest score

class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        // find the max value in the array
        int maxValue = Integer.MIN_VALUE;
        for(int num : nums){
            maxValue = Math.max(maxValue, num);
        }
        // create an array of length maxvalue
        int[] array = new int[maxValue+1];
        for( int num : nums) {
            array[num] =  array[num] + num;
        }
        // create a dp array
        int[] dp = new int[maxValue+1];
        dp[0] = array[0];
        dp[1] = Math.max(array[0],array[1]);

        for(int i=2; i< array.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+array[i]);
        }
        return dp[maxValue];
    }
}