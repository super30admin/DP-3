# Time Complexity : O(max(N)) + O(N) // We will iterate over all dp list or the maximun number of list created hence it will br O(max(N)) + O(N)
#  Space Complexity : O(max(N)) //Similary the num will be added depending on the max N in the nums
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        #Base case if the nums is empty
        if not nums:
            return 0
        #Declare max value from the array to create val array of that space 
        maxVal = max(nums)
        n = maxVal + 1
        
        #Creating an array of the index based on max value
        val = [0] * n
        
        #Iterate over nums and add up the same value with their respective index
        for num in nums:
            val[num] = val[num] + num
        #Now same as house robber we will skip or take and based on the maximum value obtained we will return the result
        skip,take = 0, val[0]
        
        for i in range(maxVal+1):
            temp = skip
            skip = max(skip,take)
            take = temp + val[i]
            
        return max(skip,take)