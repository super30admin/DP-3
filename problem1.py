'''
// Time Complexity : O(n)
// Space Complexity : O(max(nums))
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        _max = nums[0]
        for i in nums:
            _max = max(_max, i)
        _arr = [0] * (_max+1)
        for i in nums:
            _arr[i] += i
        prev = 0
        cur = _arr[1]
        for i in range(2, len(_arr)):
            _temp = cur
            cur = max(cur, prev + _arr[i])
            prev = _temp
        return cur