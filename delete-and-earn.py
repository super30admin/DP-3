# Time Complexity : O(N)
# Space Complexity : O(N) - worst case all the elements in the list are unique
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        count = collections.Counter(nums)
        
        if len(count) == 1:
            for k in count:
                return k * count[k]
        if len(count) == 2:
            output = 0
            for k in count:
                output = max(k * count[k], output)
            return output
             
        dp = [0 for _ in range(len(count))]
                    
        for i, k in enumerate(sorted(count)):
            if i == 0:
                dp[i] = k * count[k]
            elif i == 1:
                dp[i] = max(k*count[k], dp[0])
            else:
                dp[i] = max(k*count[k] + dp[i-2], dp[i-1])
        print(dp)
        return dp[len(count)-1]