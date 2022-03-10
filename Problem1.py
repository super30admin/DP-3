#  Time Complexity : O(n^2)
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No
from collections import defaultdict
class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        sum_num = 0
        points_map = defaultdict(int)
        
        for num in nums:
            points_map[num] += num
            sum_num = max(sum_num, num)
        
        max_arr = [0]*(sum_num + 1)
        max_arr[1] = points_map[1]
                          
        for num in range(2,len(max_arr)):
            max_arr[num] = max(max_arr[num - 1], max_arr[num - 2] + points_map[num])
        
        return max_arr[sum_num]