public class Solution {
    public int DeleteAndEarn(int[] nums) {
        var hashMap = new Dictionary<int,int>();
        for(var i=0;i<nums.Length;i++)
        {
            if(hashMap.ContainsKey(nums[i]))
            {
                hashMap[nums[i]] = hashMap[nums[i]] + nums[i];
            }
            else
            {
                hashMap.Add(nums[i],nums[i]);
            }
        }
        var sorted = hashMap.OrderBy(k=>k.Key);
        int max = 0;
        int[] dp= new int[sorted.Last().Key+1];
        foreach(var kvp in sorted)
        {
            int prevValue = 0;
            var key = kvp.Key-2;
            while(key>0)
            {
            if(hashMap.ContainsKey(key))
            {
                prevValue = dp[key];
                break;
            }
            else{
                key = key-1;
            }
            }
            dp[kvp.Key] = Math.Max(dp[kvp.Key-1],kvp.Value+prevValue);
        }
        return dp[sorted.Last().Key];
    }
}