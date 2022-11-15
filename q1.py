from typing import List
import sys
# Time Complexity : O(n)+O(max(nums)), where n is number of elements in nums,max(nums) is maximum value in nums List
# Space Complexity : O(max(nums)), where max(nums) is maximum value in nums List
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing Specific

class Solution:
    def actsol(self,index: int,array: List[int],memo)->int:
        if(index>=len(array)):
            return 0
        if(memo[index]!=None):
            return memo[index]
        #If don't choose that index
        l=0+self.actsol(index+1,array,memo)
        #If we choose that index
        r=array[index]+self.actsol(index+2,array,memo)
        memo[index]=max(l,r)
        return max(l,r)
    def deleteAndEarn(self, nums: List[int]) -> int:
        #First Let do some preprocessing,
        #First let us find the maximum element in nums
        maxi=-sys.maxsize - 1
        for i in nums:
            if(i>maxi):
                maxi=i
        #Let us create a array which will hold the value(frequency*index), 
        array=[0 for i in range(maxi+1)]
        for i in nums:
            array[i]+=i
        #print(array)
        memo=[None for i in range(len(array))]
        #Now let us start actual solution
        ans=self.actsol(0,array,memo)
        #print(memo)
        #print(ans)
        return ans