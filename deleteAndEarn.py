class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        points = [0] * 10001
        for num in nums:
            points[num] += num
        return self.rob(points)
    
    def rob(self, nums):
        prev = curr = 0
        for value in nums:
            prev, curr = curr, max(prev + value, curr)
        return curr
