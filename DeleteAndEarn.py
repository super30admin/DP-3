# // Time Complexity : O(n) n->> maxnumber
# // Space Complexity :O(n) n--> max number
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach

class Solution:
    def deleteAndEarnd(self, nums):

        ## our approach is to basically convert this into a house robber problem
        ## we create a new array whose size is the length of the max number and store the total of occurance of each number
        ## now this is like a house robebr problem.
        ## at each number we can either choose it or not choose it. if we chose it, the we do new[i] + prev else just curr
        ## at the end , we will be left with the maximum amount

        max_number = max(nums)
        new = [0]*(max_number+1)
        
        for i in nums:
            new[i]+= i
        
        
        prev =0
        curr = max( prev, new[0]+0)

        for i in range(1, len(new)):
            temp = curr
            curr = max(curr, prev+new[i])
            prev = temp
        
        return curr

