# Time complexity: O(n)
# Space complexity: O(n)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        n = len(nums)
        c = 0
        dc = 0
        
        # check if the nums array is empty or not
        if n == 0 or nums is None:
            return 0
        
        # initialize a new array of length of (nums + 1)
        res = [0 for i in range(max(nums) + 1)]
        
        # add all the i elements at the ith position of res
        for i in nums:
            res[i] += i
        
        # traverse the list
        for x in res:
            # keep prev value of dc in temp
            temp = dc
            # update dc value with max of both c and dc value
            dc = max(c, dc)
            # update c with (i + temp)
            c = temp + x
            
        # return the max of last C and DC values
        return max(c, dc)