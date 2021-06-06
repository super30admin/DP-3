# Time Complexity : O(n)+O(max(arr))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Converting to house robber problem as like two adjacent houses cannot be robbed
#in this case two adjacent numbers cannot be considered for output
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxEl = max(nums)
        arr = [0]*(maxEl+1)
        
        for i in range(len(nums)):
            arr[nums[i]] += nums[i]
        choose = arr[0]
        notChoose = 0
        for i in range(len(arr)):
            temp = notChoose
            notChoose = max(choose,notChoose)
            choose = arr[i]+temp
        
        return max(choose,notChoose)