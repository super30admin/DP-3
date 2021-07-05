# time complexity = O(n)
# space comlexity = O(n)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0
        x = max(nums)
        print("x is",x)
        dp = [0]* (x+1)
        print("dp is",dp)
        for num in nums:
            dp[num] += num
        choose = 0
        notchoose = 0
        for i in range(1,len(dp)):
            temp_choose = dp[i] + notchoose
            temp_notchoose = max(choose, notchoose)
            choose = temp_choose
            notchoose = temp_notchoose
        return max(choose,notchoose)
        