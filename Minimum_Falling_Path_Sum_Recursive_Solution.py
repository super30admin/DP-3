# Created by Aashish Adhikari at 4:17 PM 1/6/2021

'''
Time Complexity:
O( 2 ^ n) where n is the length of the input array

Space Complexity:
O(2 ^ n)

'''

class Solution(object):
    def minFallingPathSum(self, A):
        """
        :type A: List[List[int]]
        :rtype: int
        """
        if len(A) == 0:
            return 0

        return min(self.helper(A, 1, idx, A[0][idx] ) for idx in range(0, len(A[0])))

    def helper(self, arr, current_level, index_last_taken, current_sum):

        # base case of recursion
        if current_level > len(arr)-1:
            return current_sum

        # take the left path
        if index_last_taken is not 0:
            case1 = self.helper(arr, current_level+1, index_last_taken - 1, current_sum + arr[current_level][index_last_taken-1])
        else:
            case1 = 999999 # Since the max that can reach is 100 * 100 which is << 999999.
        if index_last_taken is not len(arr[0])-1:
            case2 = self.helper(arr, current_level+1, index_last_taken + 1, current_sum + arr[current_level][index_last_taken+1])
        else:
            case2 = 999999

        case3 = self.helper(arr, current_level+1, index_last_taken, current_sum + arr[current_level][index_last_taken])

        return min(case1, case2, case3)
