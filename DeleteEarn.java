// Time Complexity :O(n)
// Space Complexity : O(n) creating a memo array from 1 to larget elem in nums.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
  //yes dp.

// Your code here along with comments explaining your approach

  //problem simillar to house robber leetcode problem.
  //keep a count of freq of each number, then create a memoization array
  //strting from 1 to last elem. each memo array will be memo[indx = ]max of
  //memo[indx-1], or score + memo [indx-2]
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 0)
            return 0;
        //create a map to get freq of each number .
        //problem simillar to house robber leetcode problem.
        HashMap<Integer, Integer> hmp = new HashMap<>();
        int max = nums[0];
        for(int num:nums){
            hmp.put(num, hmp.getOrDefault(num,0)+1);
            max  = max < num ?num : max;
        }

        int memo[] = new int[max+1];
        int score = 0;
        for(int i = 1; i < memo.length;i++){
           memo[i] = Math.max(memo[i-1], score+(i*hmp.getOrDefault(i,0)));
           score = memo[i-1];
        }
        return memo[max];
    }
}
