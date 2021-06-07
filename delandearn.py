# Time Complexity : O(N)
# Space Complexity : O(max(input))
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


class Solution:
    def deleteAndEarn(nums) -> int:
        
        n = max(nums)
        count_arr = [0]*(n+1)
        
        #store amt earned by each number
        for i in range(len(nums)):
            count_arr[nums[i]]+=nums[i]
            
        #reduced to house robber problem
        skip = 0
        take = count_arr[0]
        
        for i in range(len(count_arr)):
            temp =skip
            skip = max(skip,take)
            take = temp+count_arr[i]
        return max(skip,take)
 
nums = [3,4,2]
print(Solution.deleteAndEarn(nums))