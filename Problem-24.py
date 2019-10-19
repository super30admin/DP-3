#Delete and Earn -740
#passed all test cases
#Time complexity =O(N)
#space Complexity =O(1) since 10000 numbers
#Approach - same like house robber problem. we need to take max elements from previous row when it is skip and for take we need to add previous skip value and cuurent value in A[i].


class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums==[]:
            return 0
        
        n= max(nums)+1
        A=[0]*n
        
        for i in nums: #create a matrix in of elements to keep track of repetative numbers
            A[i]=A[i]+i
        
        
        skip=0
        take=0
        for i in range(len(A)):
            skip,take=max(skip,take),A[i]+skip
        return max(skip,take)
        