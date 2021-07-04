#Time Complexity :  O(max(N,max(Num)))
#Space Complexity : O(max(Num))
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no

class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums)==0:
            return 0
        max_num  = max(nums)
        arr = [0 for i in range(0,max_num+1)]
        for num in nums:
            arr[num]+=num
        skip = 0
        choose = 0
        for index,num in enumerate(arr):
            prev = skip
            skip = max(skip,choose)
            choose = num +prev
        return max(skip,choose)