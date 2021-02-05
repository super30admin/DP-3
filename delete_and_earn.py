# O(N) TIME AND O(N) SPACE WHERE N IS LEN(NUMS)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        dp = [0 for i in range(max(nums)+1)]
        for num in nums:
            dp[num] += num
        choose = 0
        dontChoose = 0
        for num in dp:
            temp = dontChoose
            dontChoose = max(choose,dontChoose)
            choose = temp + num
        return max(choose,dontChoose)
            
            
        