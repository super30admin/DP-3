# Time Complexity = O(max(n)) + O(n) 
# Space Complexity = O(max(n)), because using a list to store the cummulative values of (max element of nums array + 1) size

class Solution:
    def deleteAndEarn(self, nums: list[int]) -> int:
        if nums == None or len(nums) == 0:
            return 0
        
        # Initialising system min value, to compare later and find the max in the array
        maxVal = -sys.maxsize -1 
        
        # Recursively finding the max value in the input array
        for num in nums:
            maxVal = max(maxVal, num)   
        
        # Creating an array of size max + 1, to store the cummulative results of respective numbers at their respective indices
        dp = [0] * (maxVal + 1)
        
        # Index i stores value of index i + element from nums that is equal to i
        for num in nums:
            dp[num] = dp[num] + num
         
        # Similar to house robber problem logic
        skip = 0
        take = dp[0]
        # Iterating from 1, since 0th element already initialised above
        for i in range(1, len(dp)):
            temp = skip                 # Storing the value of skip, as that will be used for the    next iteration
            skip = max(skip, take)
            take = dp[i] + temp
        
        return max(skip, take)
            