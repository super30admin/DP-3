//time complexity: O(n) or O(max element), which ever is greater
//space complexity: O(max element)
//running on leetcode: yes

class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums==null || nums.length==0)
        {
            return 0;
        }
        //get the max element
        int max=0;
        //for each num in the array nums
        for (int num:nums)
        {
            max=Math.max(max, num);
        }
        int[] dp = new int[max+1];
        for(int num : nums)
        {
            dp[num] += num;
        }
        int skip = 0, take = dp[0];
        for (int i=1; i<dp.length; i++)
        {
            int temp = skip;
            skip = Math.max(skip,take);
            take = temp + dp[i];
        }
        return Math.max(skip, take);
    }
}
