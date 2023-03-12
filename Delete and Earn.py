# Time Complexity :  O(n) + O(max(nums) i.e. length of nums + max element in nums, cannnot assume if n is smaller of max(nums) is smaller
# Space Complexity : O(max(nums)+1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxN = 0
        if len(nums) == 1:
            return nums[0]
        
        for i in nums:
            maxN = max(maxN,i)

        arr = [0] * (maxN+1)
        
        for i in nums:
            arr[i] += i

        for i in range(2,maxN+1):
            arr[i] = max(arr[i-1], arr[i]+arr[i-2])
        return arr[maxN]
