'''

Did it run on leetcode: yes
Time Complexity: 0(N)
Space Complexity: 0(1)

Algorithm:
- Create a bucket to keep a count of num in nums
- At every point our decison is solely based whether to take it or not including copies.
- We add current value in skip and check which is of greater value.


'''


class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n=10001
        count = [0]*n
        
        for num in nums:
            count[num] += num
        
        take,skip = 0,0
        
        for i in range(n):
            take_i = skip + count[i]
            skip_i = max(skip,take)
            take = take_i
            skip = skip_i
        
        return max(skip,take)
