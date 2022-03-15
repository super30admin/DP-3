
#Time Complexity : O(2**n)
#Space Complexity : O(2n)
#Did this code successfully run on Leetcode :
#Any problem you faced while coding this : No
#Recursive Solution
class Solution:
    from collections import Counter
    def deleteAndEarn(self, nums: List[int]) -> int:
        sett = set()
        return self.helper(nums,0,0,sett)
        
    def helper(self,nums,amount,i,sett):
        #base
        if i >= len(nums):
            return amount
        
        
        #not choose
        case2 = self.helper(nums,amount,i+1,sett)
        
        
        #choose
        sett2 = set()
        for k in sett:
            sett2.add(k)
            
            
        if nums[i] not in sett2:
            sett2.add(nums[i]-1)
            sett2.add(nums[i]+1)
            amount = amount + nums[i]
        case1 = self.helper(nums,amount,i+1,sett2)
        
        return max(case1,case2)


#DP - SOlution
#Time Complexity : O(n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode :
#Any problem you faced while coding this : No
class Solution:
    from collections import Counter
    def deleteAndEarn(self, nums: List[int]) -> int:
        keep = 0
        discard = 0
        dic = {}
        nums2 = []
        maxx = max(nums)
        for i in range(maxx+1):
            dic[i] = 0
        for i in nums:
                dic[i] += i
                
        for i in dic.values():
            nums2.append(i)

        for i in range(len(nums2)):
            temp = discard
            discard = max(keep,discard)
            keep = nums2[i] + temp
            
        return max(keep,discard)
        