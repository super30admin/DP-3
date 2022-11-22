# https://leetcode.com/problems/delete-and-earn/

# // Time Complexity : O(nlogn)(sorting) + O(n)(iterating again)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        hashMap = collections.defaultdict(int)
        
        for i in nums:
            if i not in hashMap.keys():
                hashMap[i] = 1
            else:
                hashMap[i] += 1
            
        nums = sorted(list(set(nums)))
        
        e1, e2 = 0, 0
        for i in range(len(nums)):
            currEarn = nums[i] * hashMap[nums[i]]
            print(currEarn)
            
            #when you can't use both currEarn and earn2 together
            
            if i > 0 and nums[i] == nums[i-1] + 1:
                temp = e2
                e2 = max(currEarn + e1, e2)
                e1 = temp        
            else:
                temp = e2
                e2 = currEarn + e2
                e1 = temp
        return e2
        