#Problem 1: Delete and Earn
#Time Complexity: O(nlogn)
#Space Complexity: O(n)
#Did this code successfully run on leetcode: yes
'''
Brute force:
create a tree that starts with the whole array and go left if we choose to delete the first element, go right if we chose not to delete. Add to the count and the next array is whatever we can delete next. Take the branch with the biggest count
                         [1,2,3,5,8]
                             /\
                            /  \
                    1[3,5,8]   0[2,3,5,8]
                       /\         /\
                      /  \       /  \
                4[5,8]  0[5,8] 2[5,8] 0[3,5,8]  etc etc
We clearly see that there are repeated subproblems
'''

'''
Optimal solution:
By symmetry of the problem, if we go in a sorted manner, only not taking nums[i]-1 is enough, because at an index , we've already done the optimal choices up to that index. We could first of all create a hashmap with the count of similar number to know how much we need to jump back. We should also sort the array since the DP geometry of the problem requires number sorting and not index. After sorting, we set up a dp matrix with rows 0 and all the nums, the columns 0,1 representing to delete the element or not delete the element. The pattern is, at a certain row, if we choose to delete,
if the previous one is the same element, we just put the same results and add value if we choose to delete. If previous one is nums[i]-1, we put the max of previous one if choose not delete and put value+delete_previous_value if we choose to delete. If previous one is smaller then nums[i]-1,we take the max of it+value if we choose to delete and the max of it if we choose not delete
'''
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        #edge case
        if not nums:
            return 0
        nums.sort()
        #since we add a 0 to the nums, we have 0:1 in the counter
        dp=[[0,0] for i in range(len(nums)+1)]
        for i in range(1,len(dp)):
            if i<2 or nums[(i-1)-1]==nums[i-1]:
                #if same number as before, add value if delete, if not delete it's the same.
                #important not to choose to delete one and not the others
                dp[i][0]=dp[i-1][0]+nums[i-1]
                dp[i][1]=dp[i-1][1]
            elif nums[(i-1)-1]==nums[i-1]-1:
                #since the previous one is nums[i]-1, we can't delete it we choose to delete the present one
                #we add the value and we add the max value if we don't delete the previous one
                dp[i][0]=nums[i-1]+dp[i-1][1]
                #if we don't delete it, then we take whatever is best from the previous row
                dp[i][1]=max(dp[i-1])
            else:
                #else we are free to take whatever we want from the one before in both cases
                #since the previous one is not nums[i]-1
                dp[i][0]=nums[i-1]+max(dp[i-1])
                dp[i][1]=max(dp[i-1])

            #like this at every stage, we have the optimal at each step if we choose to delete or not delete
            #we take the max of the last layer

        return max(dp[-1])

#Problem 2: Minimum Falling path
#Time Complexity: O(n), n number of elements of A
#Space Complexity: O(1), no extra space
#Did this code successfully run on leetcode: yes
'''
Brute force :
Length row branches, each representing a choice of one of the first row. Put the remaining possibilities we can choose from in the next row, create other branches from the remaining choices. We do that while counting the sum, we take the minimum sum branch at the end. The tree is pretty straight forward
'''
#Time Complexity: O(n), n number of elements of A
#Space Complexity: O(1), no extra space
#Did this code successfully run on leetcode: yes
'''
Main idea: We will use the list directly as our dp arrays
each index for each element represent, if we choose this element. So at each index, if we choose this element, what is the minimum I value I can get
summing all the elements before? Well it is element value + min(previous_row(index-1,index,index+1)), since if we choose this one, the previous only could've been index_row-1, index_row or index_row+1 since it can only differ by at most one. We will be careful for the boundary cases.

'''
class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        #edge case
        if not A:
            return 0
        # this first row is the same since if we choose an element, it is the minimum we can get
        for i in range(1,len(A)):
            #if we choose a certain element in that row, then the minimum we can by
            #adding all the ones before is the min from the previous row index, index-1, index+1, from the constraint
            for j in range(len(A[0])):
                if j==0:
                    A[i][j]+=min(A[i-1][j],A[i-1][j+1])
                elif j==len(A[0])-1:
                    A[i][j]+=min(A[i-1][j],A[i-1][j-1])
                else:
                    A[i][j]+=min(A[i-1][j],A[i-1][j-1],A[i-1][j+1])

        #we return the minimum of the last array
        return min(A[-1])
