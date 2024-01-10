""" Explanation: This problem is similar to the house robber problem, the only difference being that we initially need to consider the
    frequency of numbers in the array. Then I use two pointers to keep track of the elemets nums[i-1] and nums[i+1] and use DP to calculate
    the max value.
    Time Complexcity: O(n)
    Space Complexcity: O(1)
"""





class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        freqMap = [0]*(max(nums)+1)
        for num in nums :
            freqMap[num] += 1 
        
        prev2, prev1 = 0, 0              # prev2,prev1,curr
        for num in range(1,len(freqMap)) : 
            notTake = prev1
            take = num*freqMap[num] + prev2
            prev2, prev1 = prev1, max(take,notTake)
            
        return prev1

        