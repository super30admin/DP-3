"""
// Time Complexity : mentioned in the code for different approaches
// Space Complexity : mentioned in the code for different approaches
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no but haven't got the hang of DP yet 

// Your code here along with comments explaining your approach
"""

class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #Preprocessing of data
        if not nums:
            return 0
        max_val = max(nums)
        
        prep_data = [0]*(max_val + 1) #creating a list of length max_val + 1
        
        for i in nums:
            prep_data[i] += i #finding the max amount that can be earned with each eelement in nums
            
        """
        2 variables

        Time Complexity : o(n)
        Space Complexity : o(1) 
        """   
        prev_skip = 0 #will keep track of max value earned till now if the previous value is not considered
        prev_taken = prep_data[0] #will keep track of max value earned till now if the previous value is considered
        
        for i in range(1,len(prep_data)): 
            prev_s = prev_skip #storing prev_skip in a temp variable
            
            prev_skip = max(prev_taken, prev_s) #updating prev_skip with the max value if current value is not considered, that will the max value out of the previous 2 options 
            
            prev_taken = prev_s + prep_data[i] #updating prev_taken with the value obtained if current value is considered
            
        return max(prev_skip,prev_taken) #return max at the end
        
        """
        DP Array

        Time Complexity : o(n)
        Space Complexity : o(n) 
        """
        
        """
        dp = [[0,0] for i in range(len(prep_data))] #creating a dp array, dp[i][0] will keep track of max value if the current value isnt chosen and dp[i][1] will be used for when current value is chosen 
        
        dp[0][1] = prep_data[0]
        
        for i in range(1, len(prep_data)):
            dp[i][0] = max(dp[i-1][0], dp[i-1][1]) #current value not chosen, max value out of the 2 previous values
            dp[i][1] = dp[i-1][0] + prep_data[i] #current value chosen, max value for when prev value not chosen + current value 
            
        return max(dp[-1])
        """