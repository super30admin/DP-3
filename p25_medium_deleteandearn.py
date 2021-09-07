"""
https://leetcode.com/problems/delete-and-earn/

You are given an integer array nums.
You want to maximize the number of points you get by performing the following operation any number of times:
Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
Return the maximum number of points you can earn by applying the above operation some number of times.

Approach-
--At every index we chose to delete or not delete a value and follow exhaustive approach.
we calculate the max value of the nums array to find the length of the array in which we will
need to put the elements for pre processing of the data. Once we do this we create an array of size
of length maxnumber+1 so that it can accomodate all elements from 0 till the max number index. At every
index we will store value from number array = to index value. If duplicate values are found we will just
add those values at the same index. We create a dp matrix and follow top down approach. If we chose to
delete an element at a particular row we will just take the max case of chosing and not chosing deletion
from the row above. Else if we chose to delete a number we make sure the previous row and next row chosing to not deletion
case is considered and we add them both since we would want them in the list to be deleted and not initilly delete them
We finally calculate the max value at the last row of the dp matrix.

Tc: O(n) + O(max(n) whaever is higher
Sc: O(n) + O(max(n) whaever is higher

"""


class Solution:
    def deleteAndEarn(self, nums):
        if len(nums)== 0:
            return 0
        ###lets preprocess the data
        maximumnumber=max(nums)
        array=[0]*(maximumnumber+1)
        for number in nums:
            array[number]+=number

        dpmatrix=[[0 for x in range(2)] for y in range(maximumnumber+1)]
        for i in range(1, len(dpmatrix)):
            dpmatrix[i][0]= max(dpmatrix[i-1][0], dpmatrix[i-1][1])
            dpmatrix[i][1]=dpmatrix[i-1][0]+array[i]
        return max(dpmatrix[len(dpmatrix)-1])

        # skip=0
        # take=0
        # for i in range(1, len(array)):
        #     temp=skip



        ###house robber problem






        # forty five things in the life of the person who is there and not out



        # array=[]
        # for i in range(max(nums)+1):
        #     if
        #     array.insert(i, )
        # array=[]*(maximumnumber+1)
        # for i in range(maximumnumber+1):





        # dpMatrix=[[0 for x in range(2)] for y in range ()]
        #
        #
        # return 123




nums = [2,4,3,3,2,7]
solve=Solution()
print(solve.deleteAndEarn(nums))


"""
Input: nums = [2,2,3,3,3,4]
Output: 9
Explanation: You can perform the following operations:
- Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
- Delete a 3 again to earn 3 points. nums = [3].
- Delete a 3 once more to earn 3 points. nums = [].
You earn a total of 9 points.
"""