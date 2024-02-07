'''
TC: MAX(O(n), O(max(n))) -> O(k+n) 
    - k is max of nums
    - n is the number of nums
SC: O(max(n)) - n is the number of nums
'''
from typing import List

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        res = [0]*(max(nums)+1)
        for num in nums:
            res[num]+=num
        sum1, sum2 = 0,0
        for i, num in enumerate(res):
            res[i] = max(sum2, sum1+num)
            sum1, sum2 = sum2, res[i]
        return res[-1]
s = Solution()
print(s.deleteAndEarn([2,2,3,3,3,4]))
print(s.deleteAndEarn([3,4,2]))