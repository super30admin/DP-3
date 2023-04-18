class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        d = [0 for i in range(max(nums)+1)]
        for i in range(len(nums)):
            d[nums[i]] += nums[i]   
        a = 0
        b = 0 
        print(d)   
        for i in d:
            x = max(b,a + i)
            a = b
            b = x
        return b
