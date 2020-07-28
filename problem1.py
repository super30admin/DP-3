# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        mapDp = [0,0]
        values = [0 for _ in range(max(nums)+1)]
        
        for i in nums:
            values[i] += i
        # print(values)
        temp = [0,0]
        for i in range(len(values)):
            # if values[i] != 0:
            temp1 = max(mapDp)
            # print(mapDp[0], values[i])
            temp2 = mapDp[0] + values[i]
            mapDp = [temp1, temp2]
            # print(mapDp)
            
        return max(mapDp)