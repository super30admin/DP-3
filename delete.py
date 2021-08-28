# // Time Complexity :O(n),n is the max number
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach





class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxi=max(nums)
        li=[0]*(maxi+1)
        for i in nums:#O(n)
            
            li[i]=li[i]+i
        print(li)
        skip=0
        take=0
        for i in li:
            temp=skip
            skip=max(skip,take)
            take=temp+i
            print(skip)
            print(take)
        return max(skip,take)
        