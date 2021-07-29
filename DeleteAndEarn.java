// Time Complexity : O(N), N = length of array
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // Cache to store results
    private static Map<Integer, Integer> memo;
    
    public int deleteAndEarn(int[] nums) {
        // Treat this as a freq map
        Map<Integer, Integer> bucket = new HashMap<>();
        memo = new HashMap<>();
        // To get Max Key value from freq map
        int max = Integer.MIN_VALUE;
        for (int num : nums) { 
            bucket.put(num, bucket.getOrDefault(num, 0) + num);
            max = Math.max(max, num);
        }
        // Same as House Robber
        int startFromZero = helper(bucket, 0, max);
        int startFromOne = helper(bucket, 1, max);
        
        return Math.max(startFromZero, startFromOne);
    }
    
    private int helper(Map<Integer, Integer> map, int key, int max)
    {
        // If key is exceeding the max key from map. We can have 0 profit
        if(key > max)
        {
            return 0;
        }
        // If already computed for this key. Return it
        if(memo.get(key) != null)
        {
            return memo.get(key);
        }
        
        int p1 = 0, p2 = 0;
        // If freq map has this key
        // then we can either choose it and choose key + 2 for next call
        if(map.containsKey(key))
        {
            p1 = map.get(key) + helper(map, key + 2, max);
        }
        // Or we can ignore this and choose key + 1
        p2 = helper(map, key + 1, max);
        // Result will be max of either or those calls
        int profit = Math.max(p1, p2);
        // store in cache
        memo.put(key, profit);
        return profit;
    }
}