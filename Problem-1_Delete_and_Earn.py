# APPROACH 1 INTERMEDIATE SOLUTION (DP) 
# Time Complexity : O(n lgn + n^2) => O(n^2), n: length of nums
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 0. numerical neighbor of nums[i] is nums[i - 1], nums[i + 1]
# 1. Sort the nums so that we have a bound on checking it's numerical neighbors. (if the previous element is not numerical neighbor then we are sure that no elements before it,
#    are it's numerical neighbors.
# 2. Create a dp table where each element has a row and 2 columns - choose / not choose
# 3. If we are not choosing the element -> traverse till we reach the element which is not same as the current one (can be it's numerical neighbor also) and take max of it.
# 4. If we are choosing the element -> add that element plus it's duplicates before it.
#                                   -> if the 1st non-equal element is it's numerical neighbor then add the cost of not choosing it
#                                   -> if the 1st non-equal element is not it's numerical neighbor then add the max cost of choosing or not choosing it

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        
        nums.sort()
        dp = [[None for _ in range(2)] for _ in range (len(nums))]
        dp[0][0], dp[0][1] = 0, nums[0]
        
        for row in range(1, len(nums)):
            
            # Not choosing
            j = row - 1
            while nums[j] == nums[row]:
                j -= 1
            if j != -1:
                dp[row][0] = max(dp[j][0], dp[j][1])
            else:
                dp[row][0] = 0
            
            # Choosing
            j = row - 1
            dp[row][1] = nums[row]
            while nums[j] == nums[row]:
                dp[row][1] += nums[row]
                j -= 1
            
            if j != -1:
                if nums[j] == nums[row] - 1:
                    dp[row][1] += dp[j][0]

                elif nums[j] != nums[row] - 1:
                    dp[row][1] += max(dp[j][0], dp[j][1])
                
        return max(dp[-1][0], dp[-1][1])
        
        



# APPROACH 2 : OPTIMAL SOLUTION (DP)
# Time Complexity : O(max(nums)), nums: is the input array
# Space Complexity : O(max(nums))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach
# 1. first we build an array which has all the numbers till max(nums) so that we can have the numerical neighbors (nums[i] - 1, nums[i] + 1) beside each element, each cell 
#    stores the value present in actual nums
# 2. Then create a dp table that has rows for all the elements of the above modified list and 2 columns - choos / not choose
# 3. If we dont choose the element -> (as good as considering all elements before it) - max(previous row)
#    If we choose the element -> (then we must not choose the element before it), the element after it is not considered as we are filling the table bottom up (left to right) way
# 4. Final result is the max(of last row)


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        
        nums_adj = [0 for _ in range(max(nums) + 1)]
        for num in nums:
            nums_adj[num] += num
         
        dp = [[None for _ in range(2)] for _ in range(len(nums_adj))]
        dp[0][0], dp[0][1] = 0, nums_adj[0]
        
        for row in range(1, len(dp)):
            
            dp[row][0] = max(dp[row - 1][0], dp[row - 1][1])
            dp[row][1] = nums_adj[row] + dp[row - 1][0]
            
        return max(dp[-1][0], dp[-1][1])
            
