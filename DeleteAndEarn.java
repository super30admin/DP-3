package s30Coding;

// Time Complexity :- O(m+n) where M: the length of input array
//								   N: the range of the value of each int element

//Space Complexity :- O(n)

// Logic :- Similar to the house robber problem, the only things that changes is storing the sums of each occurrences in the array

public class DeleteAndEarn {
	public int deleteAndEarn(int[] nums) {
	      int[] sum = new int[10001];
	        for (int num : nums) {
	            sum[num] += num;
	        }
	        
	        int[] dp = new int[10001];
	        dp[1] = sum[1];
	        for (int i = 2; i <= 10000; i++) {
	            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sum[i]);
	        }
	        
	        return dp[10000];
	        
	    }
}
