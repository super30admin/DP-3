class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        :len(nums) = len
        :time complexity: max(O(len) + O(max(nums)))
        :space complexity: O(max(nums))) + O(len(dp))
        """
        if len(nums) == 0: return 0
        maxx=max(nums)
        arr =[0]*(max(nums)+1)
        for num in nums:
            arr[num]+=num
            #[0,0,4,9,4]
        dp = [0]*len(arr)
        dp[0]=arr[0]
        for i in range(1, len(arr)):
            dp[i] = max(arr[i]+dp[i-2], dp[i-1])
        return dp[len(arr)-1]
        
        