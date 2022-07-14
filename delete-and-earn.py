"""
Runtime Complexity:
O(n)- we iterate through nums list and go over 'n' elements by either choosing them or not to maximize our earnings.
Space Complextiy:
O(n)- because we create a 1D dp array to compute our solution.
Yes, the code worked on leetcode.
The idea behind the algorithm is to create a dp array and compute the maximum earnings by either choosing or exluding(skip) the element and this computation is done in our dp array. We return max
of skip and take to get the maximum earnings which is our solution.

"""


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        Max_n = max(nums)
        dp = [0 for i in range(Max_n+1)] 
        
        
        for num in nums:
            dp[num] = dp[num]+num
        
        skip = 0
        take = dp[0]
        print(nums)
        print(dp)
        
        for i in range(len(dp)):
            temp = skip
            skip = max(skip,take)
            take = temp+dp[i]
            
        return max(skip,take)
                