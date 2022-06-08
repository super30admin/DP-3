# Time Complexity : O(N) + O(M) when N is number of elements in the matrix and M is maximum number in the matrix
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxRange = max(nums)
        
        earnings = [0 for _ in range(maxRange + 1)]
        for n in nums:
            earnings[n] += n

        choose = earnings[0]
        notChoose = earnings[1]
        
        for i in range(2, len(earnings)):
            temp = choose
            choose = max(choose, notChoose)
            notChoose = temp + earnings[i]
            
        return max(choose, notChoose)