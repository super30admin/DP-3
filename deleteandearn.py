class Solution:
    def deleteAndEarn(self, nums):
        
        #Method 1 - With Array 
        '''
        dp = [0 for x in range(max(nums) + 1)]

        for x in nums:
            dp[x] += x


        C = 0 
        DC = 0
        for x in dp:
            temp = DC
            DC = max ( C, DC)
            C = temp + x

        
        return max (C,DC)

        # TC : O(n) where n is the max value in the given array nums
        # LeetCode running time - 52 ms
        # SC : O(n) where n is the max value in the given array nums
        # LeetCode Space = 14.7 mb
        '''

        #Method 2 - With Hashmap




        dp = {}

        for x in range(max(nums) + 1):
            dp[x] = 0

        
        for x in nums:
            dp[x] += x
        
        
        C = 0
        DC = 0

        for x in dp:
           
            temp = DC

            DC = max(C, DC)
            C = temp + dp[x]

        print(dp)
        return max(C,DC)


        # TC : O(n) where n is the maximum - LeetCode running time - 44ms
        # SC: O(n) where n is the maximu - LeetCode Space  = 14.7 mb

         
