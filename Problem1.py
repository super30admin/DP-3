# // Time Complexity : O(n+m) where n is the len of nums, m is the max value in the given array
# // Space Complexity : O(m) 
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : no
class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # when we delete a value of x then the array automatically clears up the values of x+1, x-1 in the array and we earned x points
        # in the array [3,4,2] if i delete 3 then. it automatically clears the 4,2 so only 3 points 
        # but if i delete 4 then i get 4+2 points 6 
        # so the tric part is how do i delete the values such that i can earn more points
        # lets take a big array example [2,1,8,1,2,4,4,4,6,4,4,7,3,3,7] 
        # ok gng to find the max of the value, lets say m in the given array and create an array of size m 
        # in each index we save the max earnings we can get by deleting index value in our nums arr.
        # 0 earnings 0 
        # 1 by deleting 1 we earn 1+1 two 1’s in the array 2
        # 3 we have 2 elements of 3 in array so  6 
        # 4 we have 4 , 4’s so total 16 
        # so now the earnings arr = [0,2,6,16,0,6,14,8]
        # once we get this arr, now if we select 1st index we cannot select the next index so its basically the adjance index we can't select 
        # as the adjancent index are 1 greate or 1 lesser than its valeu so now the probelm is we just have to find the max value we can earn in this arr by skiping the adjancent index

        m = max(nums) 

        earnings = [0]*(m+1) # intial earnings as 0 # sc O(n)

        for num in nums:
            earnings[num] += num # earnings[i] represent the number of points we can earn by deleting ith value in num

        prev = earnings[0]
        curr = max(earnings[0], earnings[1])
        # print(earnings)

        for i in range(2,m+1):
            temp = curr
            case1 = curr # not deleting this value 
            case2 = earnings[i] + prev # selecting this value to delete = value earned at this index + value earned at i-2 index ( avodign the adjancent)
            curr = max(case1,case2)
            # print(case1,case2,curr)
            prev = temp

        return curr

