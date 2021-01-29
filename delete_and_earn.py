'''
Time complexity: O(n)
Space complexity: O(n)
'''
class Solution:
    dp = [0] * (self.getMax(nums) + 1)
        for x in nums:
            dp[x] += x
            
        c = 0 # choose
        dc = 0 # don't choose
        for x in dp:
            temp = dc
            dc = max(c, dc)  # dont choose value = max(prev choose and prev dont choose)
            c = temp + x # choose value = sum of current number + dc of previous number
        return max(c, dc)

    def getMax(self, nums): # to get the length of the array to be constrcuted. It will of the size of max number in the original array
        max = 0
        for x in nums:
            if x > max:
                max = x
                
        return max