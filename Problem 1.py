# Time: O(mx-mn)
# Space: O(1)
class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        dic = {}
        mn = min(nums)
        mx = max(nums)
        for i in range(mn, mx+1):
            if i not in dic:
                dic[i] = 0
        for i in nums:
            dic[i] += i
        taken = 0
        not_taken = 0
        for i in range(mn, mx+1):
            prevnottaken = not_taken
            not_taken = max(taken, not_taken)
            taken = dic[i]+prevnottaken
        return max(taken, not_taken)
            
        
        
        
