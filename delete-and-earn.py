# Take a 1D array 'a' with the length of the max number in nums. Loop through nums 
# and add each element into a[ind] forming total sum of unique elements present at 
# their unique indices. Assign a[0] to prev2 and a[1] to prev1. Loop through a from 
# the second element and assign the max between element+prev2 and prev1 to current. 
# In the next iteration, repreat the process such that prev1 becomes the current and
#  prev2 becomes prev1

# Time complexity: O(m)
# Space complexity: O(m) where m is the max number in nums

class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        a=[0 for i in range(max(nums)+1)]
        for i in nums:
            a[i]=a[i]+i

    
        l = len(a)
        if l ==1:
            return a[0]
        prev2=a[0]
        prev1=max(a[1],a[0])
        current=prev1
        for i in range(2,l):
            current =max(prev1,prev2+a[i])
            prev2=prev1
            prev1=current
        return current