# Created by Aashish Adhikari at 3:09 PM 1/6/2021

'''
Time Complexity:
case 1: if the max element in the input is too large, we create a large array of this size.
eg, input = [1,2, 999999]
    Here, we iterate ~999999 times to create a new array cumul of length ~ 999999

case 2: if a small number repeats many time.
eg, [1,1,1,1,1,1,1,1,1,1,1,1,................. 999999 times]
    Here, length of cumul array ~ 1 but we iterate "length of input" times to create this cumul array.

case3: regardless of the above cases, the helper function traverses through a binary tree.
        O(2 ^ (n/2)) ) in the worst case where n is the length of the array input

Hence time complexity: max( O(max element in input), O(n) , O(2 ^ (n/2)) )

Space Complexity:
O(maximum element in the input)
'''


class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        if len(nums) == 0:
            return 0

        # find the max
        maxi = max(nums)

        # create a cumulative array for each element in nums
        cumul = [0 for idx in range(0, maxi+1)]

        # fill in the cumulative sum of each element in the corresponding index
        for idx in range(0, len(nums)):
            elem = nums[idx]
            cumul[elem] += elem


        # do recursive solution now
        return self.helper(cumul, 0, 0)



    def helper(self, cumul_arr, index, running_sum):

        # base case of recursion
        if index > len(cumul_arr)-1:
            return running_sum

        case1 = self.helper(cumul_arr, index+1, running_sum)
        case2 = self.helper(cumul_arr, index+2, running_sum + cumul_arr[index])

        return max(case1, case2)