# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No, since the explanation from class was clear.


# Your code here along with comments explaining your approach
# Dynamic Programming approach from class, where we convert this problem to house robber problem 
# and then we use skip and take to take solution from the sub problems and use to solve bigger problems

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxi = -1
        mapping = defaultdict(lambda: 0)
        for i in range(len(nums)):
            if nums[i] > maxi:
                maxi = nums[i]
            
            mapping[nums[i]] += 1
        
        numbers = [0 for x in range(maxi+1)]
        for i in range(maxi+1):
            numbers[i] = i*mapping[i]
        
        skip, take = 0, 0

        for i in range(maxi+1):
            temp = skip
            skip = max(skip, take)
            take = numbers[i] + temp
            
        return max(skip, take)