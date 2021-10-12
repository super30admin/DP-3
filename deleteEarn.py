class Solution:
    
    # TC max (O(n),O(max element))
    # SC O(max element)
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums ) == 0:
            return 0
        maxs = 0
        for n in nums:
            maxs = max(n, maxs)
        print(maxs)
        dp = [0] * (maxs +1)

        for n in nums:
            dp[n] += n
        skip = 0
        take = dp[0]
        for n in dp:
            temp = skip
            skip = max(skip, take)
            take = temp + n
        return max(skip,take)
            
